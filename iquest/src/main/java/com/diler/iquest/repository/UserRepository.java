package com.diler.iquest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diler.iquest.model.User;

// Repository for User database operations
// JpaRepository provides: save, findById, findAll, deleteById, etc.
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Spring auto-generates the SQL
}