package com.example.authTesting.repository;

import java.time.Instant;
import java.util.Optional;

import com.example.authTesting.entity.RefreshToken;
import com.example.authTesting.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByExpiryDateBefore(Instant now);
    @Transactional
    void deleteByToken(String token);
    @Transactional
    void deleteByUserId(Long userId);

    @Modifying
    int deleteByUser(User user);
}
