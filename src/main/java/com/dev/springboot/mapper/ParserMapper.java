package com.dev.springboot.mapper;

import com.dev.springboot.dto.ParserDto;
import com.dev.springboot.model.Product;
import com.dev.springboot.model.Review;
import com.dev.springboot.model.UserCsv;
import java.time.Instant;
import java.time.LocalDate;
import java.util.TimeZone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParserMapper {
    private static final String WORD = "food";

    public UserCsv parser(ParserDto dto) {
        Review review = Review.builder()
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
        product.setFood(review.getText()
                .toLowerCase().contains(WORD)
                || review.getSummary()
                .toLowerCase().contains(WORD));
        UserCsv user = new UserCsv();
        user.getReviews().add(review);
        user.getProducts().add(product);
        user.setUserId(dto.getUserId());
        user.setProfileName(dto.getProfileName());
        return user;
    }
}
