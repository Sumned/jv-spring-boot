package com.dev.springboot.service.impl;

import com.dev.springboot.model.Product;
import com.dev.springboot.model.Review;
import com.dev.springboot.model.UserCsv;
import com.dev.springboot.repository.UserCsvRepository;
import com.dev.springboot.service.ProductService;
import com.dev.springboot.service.ReviewService;
import com.dev.springboot.service.UserCsvService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCsvServiceImpl implements UserCsvService {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private final UserCsvRepository userRepository;
    private final ReviewService reviewService;
    private final ProductService productService;

    @Override
    public UserCsv addUser(UserCsv user) {
        UserCsv userDb = new UserCsv();
        userDb.setUserId(user.getUserId());
        userDb.setProfileName(user.getProfileName());
        Review review = reviewService.addReview(user.getReviews().get(FIRST_ELEMENT_INDEX));
        Product product = user.getProducts().get(FIRST_ELEMENT_INDEX);
        if (!product.isFood() && productService.getByProductId(product.getProductId()) != null) {
            product.setFood(productService.getByProductId(product.getProductId()).isFood());
        }
        product.getReviews().add(review);
        product = productService.addProduct(product);
        userDb.getProducts().add(product);
        userDb.getReviews().add(review);
        return userRepository.save(userDb);
    }

    @Override
    public Page<String> getAll(Pageable pageable) {
        return userRepository.getAll(pageable);
    }
}
