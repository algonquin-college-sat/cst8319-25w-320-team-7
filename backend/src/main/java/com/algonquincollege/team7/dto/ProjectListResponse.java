package com.algonquincollege.team7.dto;

import com.algonquincollege.team7.model.Project;
import com.algonquincollege.team7.model.Semester;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record ProjectListResponse(
        Long id,
        String projectName,
        String description,
        Semester semester,
        Boolean ndaRequired,
        Boolean showcaseAllowed,
        LocalDateTime createdAt,
        List<ProjectTagResponse>tags

) {
    public static ProjectListResponse fromProject(Project project) {
        return new ProjectListResponse(
                project.getId(),
                project.getProjectName(),
                project.getDescription(),
                project.getSemester(),
                project.getNdaRequired(),
                project.getShowcaseAllowed(),
                project.getCreatedAt(),
                project.getTags().stream().map(ProjectTagResponse::new).collect(Collectors.toList())
        );
    }
}