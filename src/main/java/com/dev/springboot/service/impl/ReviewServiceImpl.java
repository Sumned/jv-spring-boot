package com.dev.springboot.service.impl;

import com.dev.springboot.model.Review;
import com.dev.springboot.repository.ReviewRepository;
import com.dev.springboot.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
