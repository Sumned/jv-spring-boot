package com.dev.springboot.controller.authentication;

import com.dev.springboot.dto.user.UserRequestDto;
import com.dev.springboot.mapper.UserMapper;
import com.dev.springboot.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registration")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public String register(@RequestBody UserRequestDto requestDto) {
        authenticationService.register(userMapper
                .getUserFromRequestDto(requestDto));
        return "Registration successful";
    }
}
