package com.dev.springboot.service.impl;

import com.dev.springboot.model.User;
import com.dev.springboot.repository.UserRepository;
import com.dev.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
