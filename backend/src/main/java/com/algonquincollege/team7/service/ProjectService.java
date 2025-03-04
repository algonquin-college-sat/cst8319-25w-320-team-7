package com.algonquincollege.team7.service;

import com.algonquincollege.team7.dto.ProjectRegistrationRequest;
import com.algonquincollege.team7.infra.exception.ApiException;
import com.algonquincollege.team7.model.Project;
import com.algonquincollege.team7.model.UserType;
import com.algonquincollege.team7.repository.ProjectRepository;
import com.algonquincollege.team7.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public void registerProject(@RequestBody @Valid ProjectRegistrationRequest data) {

        var invalidOrganizationId = !userRepository.existsByIdAndType(data.organizationId(), UserType.valueOf("ORGANIZATION"));
        if (invalidOrganizationId) {
            throw new ApiException(HttpStatus.CONFLICT, "Invalid organization ID");
        }

        var user = userRepository.findById(data.organizationId()).get();

        var project = new Project(data, user);
        System.out.println(project);
        projectRepository.save(project);
    }
}