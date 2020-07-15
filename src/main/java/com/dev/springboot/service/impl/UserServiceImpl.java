package com.dev.springboot.service.impl;

import com.dev.springboot.model.Product;
import com.dev.springboot.model.Review;
import com.dev.springboot.model.User;
import com.dev.springboot.repository.UserRepository;
import com.dev.springboot.service.ProductService;
import com.dev.springboot.service.ReviewService;
import com.dev.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private final UserRepository userRepository;
    private final ReviewService reviewService;
    private final ProductService productService;

    @Override
    public User addUser(User user) {
        User userDb = new User();
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
