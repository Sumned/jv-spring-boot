package com.dev.springboot.service;

import com.dev.springboot.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User addUser(User user);

    Page<String> getAll(Pageable pageable);
}
