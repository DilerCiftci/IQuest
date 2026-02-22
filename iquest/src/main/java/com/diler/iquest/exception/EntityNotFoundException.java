package com.diler.iquest.exception;

// Thrown when a requested resource doesn't exist (caught by GlobalExceptionHandler)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
