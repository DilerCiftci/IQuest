package com.diler.iquest.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateCardRequest(
        @NotBlank String question,
        @NotBlank String answer) {
}