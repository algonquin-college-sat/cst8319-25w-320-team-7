package com.algonquincollege.team7.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TagTypeRequest(
        Long id,

        @NotBlank(message = "Tag type is required")
        @Size(max = 50, message = "Tag type must be under 50 characters")
        @Size(min = 1, message = "Tag type must have at least 1 character")
        String name) {
}
