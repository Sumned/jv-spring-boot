package com.dev.springboot.service.impl;

import com.dev.springboot.model.Review;
import com.dev.springboot.model.Word;
import com.dev.springboot.repository.ReviewRepository;
import com.dev.springboot.service.ReviewService;
import com.dev.springboot.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final WordService wordService;

    @Override
    public Review addReview(Review review) {
        for (String s : review.getText().replace("<br", "")
                .replace("br/>", "")
                .replaceAll("(\\W+)", " ")
                .split(" ")) {
            wordService.save(new Word(s));
        }
        return reviewRepository.save(review);
    }
}
