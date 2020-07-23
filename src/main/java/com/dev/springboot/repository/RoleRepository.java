package com.dev.springboot.repository;

import com.dev.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRoleName(Role.RoleName role);
}
