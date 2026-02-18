package com.diler.iquest.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateCardRequest(
        @NotBlank String question,
        @NotBlank String answer) {
}