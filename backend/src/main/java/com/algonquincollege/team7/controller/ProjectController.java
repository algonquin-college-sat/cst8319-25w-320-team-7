package com.algonquincollege.team7.controller;

import com.algonquincollege.team7.dto.ProjectRegistrationRequest;
import com.algonquincollege.team7.dto.ProjectRegistrationResponse;
import com.algonquincollege.team7.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity registerProject(@RequestBody @Valid ProjectRegistrationRequest data) {

        projectService.registerProject(data);
        var responseOk = new ProjectRegistrationResponse("Project registered successfully");
        return ResponseEntity.ok(responseOk);
    }
}
