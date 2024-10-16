package com.example.authTesting.service.impl;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.example.authTesting.entity.RefreshToken;
import com.example.authTesting.exception.TokenRefreshException;
import com.example.authTesting.repository.RefreshTokenRepository;
import com.example.authTesting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RefreshTokenService {
    @Value("${security.jwt.refresh-expiration-time}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(Long userId) {
        refreshTokenRepository.deleteByUserId(userId);
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userRepository.findById(userId).isPresent() ? userRepository.findById(userId).get() : null);
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }

        return token;
    }

    @Transactional
    public int deleteByUserId(Long userId) {
        return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }

    @Transactional
    public void deleteByToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
