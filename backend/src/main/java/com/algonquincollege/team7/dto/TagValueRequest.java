package com.algonquincollege.team7.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TagValueRequest(
        Long id,

        @NotNull(message = "Tag type Id is required")
        Long tagTypeId,

        @NotBlank(message = "Tag value is required")
        @Size(max = 100, message = "Tag value must be under 100 characters")
        @Size(min = 1, message = "Tag value must have at least 1 character")
        String value) {
}
