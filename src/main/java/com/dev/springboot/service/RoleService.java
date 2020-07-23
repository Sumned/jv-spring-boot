package com.dev.springboot.service;

import com.dev.springboot.model.Role;

public interface RoleService {
    Role addRole(Role role);

    Role getRoleByRoleName(Role.RoleName role);

}
