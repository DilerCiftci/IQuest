package com.diler.iquest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateDeckRequest(
                @NotBlank(message = "Deck name is required") @Size(min = 1, max = 100, message = "Deck name must be between 1 and 100 characters") String name) {
}