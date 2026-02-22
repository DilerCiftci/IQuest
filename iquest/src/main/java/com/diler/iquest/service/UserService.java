package com.diler.iquest.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.diler.iquest.exception.EntityNotFoundException;
import com.diler.iquest.model.User;
import com.diler.iquest.repository.UserRepository;

// Service layer for user operations (registration, login, etc.)
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // For password encryption

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

        String hashedPassword = passwordEncoder.encode(password); // Encrypt password
        User user = new User(username, hashedPassword, role);
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required.");
        }
        return userRepository.findByUsername(username);
    }

    public User getUser(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User id is required.");
        }
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }

    public User loginUser(String username, String password) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is required.");
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + username));

        if (!passwordEncoder.matches(password, user.getPassword())) { // Compare encrypted passwords
            throw new IllegalArgumentException("Invalid password.");
        }

        return user;
    }
}