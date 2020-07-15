package com.dev.springboot.controller;

import com.dev.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Page<String> get(@PageableDefault(page = 0, size = 1000) Pageable pageable) {
        return userService.getAll(pageable);
    }
}
