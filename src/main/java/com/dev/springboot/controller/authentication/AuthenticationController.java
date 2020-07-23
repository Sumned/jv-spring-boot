package com.dev.springboot.controller.authentication;

import com.dev.springboot.dto.user.UserRequestDto;
import com.dev.springboot.mapper.UserMapper;
import com.dev.springboot.security.AuthenticationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registration")
@Log4j2
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public HttpStatus register(@RequestBody UserRequestDto requestDto) {
        log.info("try to register user " + requestDto.getEmail());
        try {
            authenticationService.register(userMapper
                    .getUserFromRequestDto(requestDto));
            log.info("registration successful " + requestDto.getEmail());
            return HttpStatus.ACCEPTED;
        } catch (Exception e) {
            return HttpStatus.NOT_ACCEPTABLE;
        }
    }
}
