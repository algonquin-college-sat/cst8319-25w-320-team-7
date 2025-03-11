package com.algonquincollege.team7.controller;

import com.algonquincollege.team7.dto.*;
import com.algonquincollege.team7.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Transactional
    @PostMapping
    public ResponseEntity registerProject(@RequestBody @Valid ProjectRegistrationRequest data) {

        projectService.registerProject(data);
        var responseOk = new ProjectRegistrationResponse("Project registered successfully");
        return ResponseEntity.ok(responseOk);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<ProjectListResponseWrapper> getProjectsByOrganization(
            @PathVariable Long organizationId,
            @ModelAttribute ProjectListRequest request) {

        ProjectListResponseWrapper response = projectService.getProjectsByOrganizationId(organizationId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectViewResponse> findProjectById(@PathVariable Long projectId) {

        ProjectViewResponse response = projectService.findProjectById(projectId);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PutMapping
    public ResponseEntity editProject(@RequestBody @Valid ProjectEditRequest data) {

        projectService.editProject(data);
        var responseOk = new ProjectEditResponse("Project updated successfully");
        return ResponseEntity.ok(responseOk);
    }
}
