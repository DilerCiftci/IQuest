package com.diler.iquest.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateDeckRequest(
        @NotBlank String name
) {}