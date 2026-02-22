package com.diler.iquest.dto.response;

// Flashcard data sent to frontend
public record CardDTO(
                Long id,
                String question,
                String answer) {
}