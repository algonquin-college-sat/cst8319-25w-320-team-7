package com.algonquincollege.team7.service;

import com.algonquincollege.team7.dto.ValidationRequest;
import com.algonquincollege.team7.infra.exception.ApiException;
import com.algonquincollege.team7.model.User;
import com.algonquincollege.team7.model.UserType;
import com.algonquincollege.team7.model.Validation;
import com.algonquincollege.team7.repository.ProjectRepository;
import com.algonquincollege.team7.repository.UserRepository;
import com.algonquincollege.team7.repository.ValidationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ValidationService {

    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public void registerValidation(@RequestBody @Valid ValidationRequest data) {
        var project = projectRepository.findById(data.projectId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Project not found"));

        var professor = validateProfessor(data.professorId());

        var validation = new Validation(data, project, professor);
        validationRepository.save(validation);
    }

    public void editValidation(@RequestBody @Valid ValidationRequest data) {
        var project = projectRepository.findById(data.projectId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Project not found"));

        var professor = validateProfessor(data.professorId());

        var validation = validationRepository.findByProjectId(data.projectId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Validation not found"));

        validation.updateFrom(data);
        validationRepository.save(validation);
    }

    private User validateProfessor(Long professorId){
        var invalidProfessorId = !userRepository.existsByIdAndType(professorId,
                UserType.valueOf("PROFESSOR"));

        if (invalidProfessorId) {
            throw new ApiException(HttpStatus.CONFLICT, "Invalid professor ID");
        }

        var professor = userRepository.findById(professorId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Professor not found"));

        return professor;
    }
}
