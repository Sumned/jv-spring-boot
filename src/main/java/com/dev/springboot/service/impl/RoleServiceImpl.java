package com.dev.springboot.service.impl;

import com.dev.springboot.model.Role;
import com.dev.springboot.repository.RoleRepository;
import com.dev.springboot.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByRoleName(Role.RoleName role) {
        return roleRepository.getRoleByRoleName(role);
    }
}
