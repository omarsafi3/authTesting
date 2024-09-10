package com.example.authTesting.service.impl;

import com.example.authTesting.entity.Review;
import com.example.authTesting.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ReviewService {
    @Autowired
    private ReviewRepository repository;



    public Review addReview(Review review) {
        return repository.save(review);

    }
    public void deleteReviewById(int id) {
        repository.deleteById(id);
    }




    public Optional<Review> updateReview(int id,Review updatedReview) {
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
