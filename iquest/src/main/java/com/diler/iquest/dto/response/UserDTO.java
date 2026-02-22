package com.diler.iquest.dto.response;

// User data sent to frontend (no password!)
public record UserDTO(
                Long id,
                String username) {
}