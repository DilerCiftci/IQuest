package com.diler.iquest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCardRequest(
        @NotBlank(message = "Question is required")
        @Size(min = 1, max = 500, message = "Question must be between 1 and 500 characters")
        String question,
        
        @NotBlank(message = "Answer is required")
        @Size(min = 1, max = 1000, message = "Answer must be between 1 and 1000 characters")
        String answer
) {}