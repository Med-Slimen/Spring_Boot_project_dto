package com.slimene.projects.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slimene.projects.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
