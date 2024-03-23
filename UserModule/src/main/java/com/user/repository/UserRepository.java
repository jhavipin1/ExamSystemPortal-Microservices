package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
