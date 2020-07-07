package com.dev.springboot.mapper;

import com.dev.springboot.model.Product;
import com.dev.springboot.model.Review;
import com.dev.springboot.model.User;
import com.dev.springboot.model.dto.ParserDto;
import com.dev.springboot.service.ProductService;
import com.dev.springboot.service.ReviewService;
import com.dev.springboot.service.UserService;
import java.time.Instant;
import java.time.LocalDate;
import java.util.TimeZone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParserMapper {
    private final UserService userService;
    private final ProductService productService;
    private final ReviewService reviewService;

    public void parser(ParserDto dto) {
        Review review = Review.builder()
                .id(dto.getId())
                .helpfulnessNumerator(dto.getHelpfulnessNumerator())
                .helpfulnessDenominator(dto.getHelpfulnessDenominator())
                .score(dto.getScore())
                .time(LocalDate.ofInstant(Instant.ofEpochSecond(dto.getTime()),
                        TimeZone.getTimeZone("UTC").toZoneId()))
                .summary(dto.getSummary())
                .text(dto.getText())
                .build();
        Product product = new Product();
        product.setProductId(dto.getProductId());
        User user = new User();
        user.getReviews().add(reviewService.addReview(review));
        user.getProducts().add(productService.addProduct(product));
        user.setUserId(dto.getUserId());
        user.setProfileName(dto.getProfileName());
        userService.addUser(user);
    }
}
