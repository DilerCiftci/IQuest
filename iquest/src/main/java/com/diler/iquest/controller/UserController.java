package com.diler.iquest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diler.iquest.dto.request.LoginRequest;
import com.diler.iquest.dto.request.RegisterRequest;
import com.diler.iquest.dto.response.LoginResponse;
import com.diler.iquest.dto.response.UserDTO;
import com.diler.iquest.model.User;
import com.diler.iquest.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// REST API for user operations: register, login, get user
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO registerUser(@Valid @RequestBody RegisterRequest request) {
        User user = userService.createUser(request.username(), request.password(), "USER");
        return new UserDTO(user.getId(), user.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        User user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
        LoginResponse response = new LoginResponse(user.getId(), user.getUsername(), user.getRole());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return new UserDTO(user.getId(), user.getUsername());
    }
}
