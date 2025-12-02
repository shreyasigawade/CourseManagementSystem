package com.example.cmsspringbootrestjpamavenproject.dao;

import com.example.cmsspringbootrestjpamavenproject.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
