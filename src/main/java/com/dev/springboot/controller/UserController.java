package com.dev.springboot.controller;

import com.dev.springboot.model.Role;
import com.dev.springboot.model.User;
import com.dev.springboot.security.AuthenticationService;
import com.dev.springboot.service.RoleService;
import com.dev.springboot.service.UserCsvService;
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
    private static final int NUMBER = 1000;
    private final UserCsvService userService;
    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    @GetMapping("/create_admin")
    public String createAdmin() {
        User user = new User();
        user.setEmail("admin@user.com");
        user.setPassword("admin");
        user.addRoles(roleService.addRole(new Role(Role.RoleName.ADMIN)));
        user.addRoles(roleService.addRole(new Role(Role.RoleName.USER)));
        authenticationService.register(user);
        return "admin injected";
    }

    @GetMapping("/most-active")
    public Page<String> getMostActive(@PageableDefault(size = NUMBER) Pageable pageable) {
        return userService.getAll(pageable);
    }
}
