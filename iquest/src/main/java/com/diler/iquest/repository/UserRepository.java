package com.diler.iquest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diler.iquest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}