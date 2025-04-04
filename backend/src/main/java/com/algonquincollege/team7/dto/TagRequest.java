package com.algonquincollege.team7.dto;

import jakarta.validation.constraints.NotNull;

public record TagRequest(
        @NotNull(message = "Project Id is required")
        Long projectId,

        @NotNull(message = "Tag value Id is required")
        Long tagValueId,

        @NotNull(message = "Professor Id is required")
        Long professorId) {
}
