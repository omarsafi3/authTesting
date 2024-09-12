package com.example.authTesting.service.impl;

import com.example.authTesting.dto.ReviewDTO;
import com.example.authTesting.dto.UserDTO;
import com.example.authTesting.entity.User;
import com.example.authTesting.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by email
        Optional<User> userDetail = repository.findByEmail(username);
        System.out.println("User Roles: " + userDetail.get().getRoles());
        // Return the user if found, or throw an exception if not
        return userDetail.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public String addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return "User Added Successfully";
    }

    public List<User> allUsers() {

        return new ArrayList<>(repository.findAll());
    }
    @Transactional
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> user = repository.findById(id);

        // Convert entity to DTO and map the reviews manually if needed
        return user.map(this::convertToDTO);
    }
    public UserDTO convertToDTO(User user) {
        // Map the User fields
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());

        // Map Reviews to ReviewDTOs
        List<ReviewDTO> reviewDTOs = user.getReviews().stream()
                .map(review -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setId(review.getId());
                    reviewDTO.setText(review.getText());
                    reviewDTO.setRate(review.getRate());
                    reviewDTO.setProduct(review.getProduct());
                    return reviewDTO;
                })
                .collect(Collectors.toList());
        userDTO.setReviews(reviewDTOs);

        return userDTO;
    }




}
