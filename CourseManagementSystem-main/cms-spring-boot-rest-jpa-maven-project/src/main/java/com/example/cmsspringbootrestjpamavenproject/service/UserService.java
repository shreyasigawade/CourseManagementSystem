package com.example.cmsspringbootrestjpamavenproject.service;


import com.example.cmsspringbootrestjpamavenproject.dao.UserRepository;
import com.example.cmsspringbootrestjpamavenproject.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        public User register(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

    public boolean authenticate(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get(); // unwrap
            return user.getPassword().equals(password);
        }

        return false; // user not found
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }



}
