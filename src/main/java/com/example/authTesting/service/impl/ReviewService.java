package com.example.authTesting.service.impl;

import com.example.authTesting.entity.Review;
import com.example.authTesting.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    public Review addReview(Review review) {
        return repository.save(review);

    }
    public void deleteReview(Long id) {
        repository.deleteById(id);
    }

    public Optional<Review> updateReview(Long id,Review updatedReview) {
        return repository.findById(id)
                .map(review -> {
                    review.setText(updatedReview.getText());
                    review.setRate(updatedReview.getRate());
                    review.setProduct(updatedReview.getProduct());
                    review.setUser(updatedReview.getUser());
                    return repository.save(review);
                });
    }
}
