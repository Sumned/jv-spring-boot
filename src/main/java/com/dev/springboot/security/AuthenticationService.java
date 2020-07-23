package com.dev.springboot.security;

import com.dev.springboot.model.User;

public interface AuthenticationService {

    User register(User user);
}
