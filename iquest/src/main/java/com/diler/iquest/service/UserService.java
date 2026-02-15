package com.diler.iquest.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.diler.iquest.model.User;
import com.diler.iquest.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create user
    public User createUser(String username, String password, String role) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is required.");
        }
        if (role == null || role.isBlank()) {
            throw new IllegalArgumentException("Role is required.");
        }

        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(username, hashedPassword, role);
        return userRepository.save(user);
    }

    // Find user by username
    public Optional<User> findByUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required.");
        }
        return userRepository.findByUsername(username);
    }
}