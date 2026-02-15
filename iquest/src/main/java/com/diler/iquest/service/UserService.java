package com.diler.iquest.service;

import org.springframework.stereotype.Service;

import com.diler.iquest.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}