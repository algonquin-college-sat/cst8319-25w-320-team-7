package com.algonquincollege.team7.dto;

import com.algonquincollege.team7.model.Project;
import com.algonquincollege.team7.model.Semester;
import com.algonquincollege.team7.model.Validation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record ProjectViewResponse(
        Long id,
        String projectName,
        String description,
        Integer availableTime,
        String purchasingRequirements,
        Boolean ndaRequired,
        Boolean showcaseAllowed,
        Semester semester,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String professorFeedback,
        List<ProjectTagResponse> tags
) {

    public ProjectViewResponse(Project data, Validation validation) {
        this(
                data.getId(),
                data.getProjectName(),
                data.getDescription(),
                data.getAvailableTime(),
                data.getPurchasingRequirements(),
                data.getNdaRequired(),
                data.getShowcaseAllowed(),
                data.getSemester(),
                data.getCreatedAt(),
                data.getUpdatedAt(),
                validation != null ? validation.getProfessorFeedback() : null,
                data.getTags().stream().map(ProjectTagResponse::new).collect(Collectors.toList())
        );
    }

}