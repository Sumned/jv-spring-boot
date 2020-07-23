package com.dev.springboot.security;

import com.dev.springboot.model.Role;
import com.dev.springboot.model.User;
import com.dev.springboot.service.RoleService;
import com.dev.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRoles(roleService.getRoleByRoleName(Role.RoleName.USER));
        user = userService.addUser(user);
        return user;
    }
}
