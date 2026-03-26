package com.slimene.projects.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slimene.projects.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
