package com.example.cmsspringbootrestjpamavenproject.controller;

import com.example.cmsspringbootrestjpamavenproject.dao.entity.User;
import com.example.cmsspringbootrestjpamavenproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("v1")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> existingUserOpt = userService.findByUsername(user.getUsername());

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            // Use passwordEncoder to compare hashed passwords
            if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
    }



}
