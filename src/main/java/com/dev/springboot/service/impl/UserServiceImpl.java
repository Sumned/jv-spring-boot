package com.dev.springboot.service.impl;

import com.dev.springboot.model.User;
import com.dev.springboot.repository.ProductRepository;
import com.dev.springboot.repository.UserRepository;
import com.dev.springboot.service.ReviewService;
import com.dev.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private final UserRepository userRepository;
    private final ReviewService reviewService;
    private final ProductRepository productRepository;

    @Override
    public User addUser(User user) {
        User userDb = new User();
        userDb.setUserId(user.getUserId());
        userDb.setProfileName(user.getProfileName());
        userDb.getProducts().add(productRepository.save(user.getProducts().get(FIRST_ELEMENT_INDEX)));
        userDb.getReviews().add(reviewService.addReview(user.getReviews().get(FIRST_ELEMENT_INDEX)));
        return userRepository.save(userDb);
    }
}
