package com.algonquincollege.team7.service;

import com.algonquincollege.team7.dto.TagRequest;

import com.algonquincollege.team7.infra.exception.ApiException;
import com.algonquincollege.team7.model.Tag;
import com.algonquincollege.team7.model.UserType;
import com.algonquincollege.team7.repository.ProjectRepository;
import com.algonquincollege.team7.repository.TagRepository;
import com.algonquincollege.team7.repository.TagValueRepository;
import com.algonquincollege.team7.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TagValueRepository tagValueRepository;

    @Autowired
    private UserRepository userRepository;

    public void registerTag(@RequestBody @Valid TagRequest data) {
        validateTag(data);

        var project = projectRepository.findById(data.projectId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Project not found"));

        var tagValue = tagValueRepository.findById(data.tagValueId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Tag value not found"));

        var professor = userRepository.findById(data.professorId())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Professor not found"));

        var tag = new Tag(project, tagValue, professor);
        tagRepository.save(tag);
    }

    public void deleteTag(Long Id) {
        if (!tagRepository.existsById(Id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Project not found");
        }

        tagRepository.deleteById(Id);
    }

    private void validateTag(@RequestBody @Valid TagRequest data) {
        var invalidProfessorId = !userRepository.existsByIdAndType(data.professorId(),
                UserType.valueOf("PROFESSOR"));

        if (invalidProfessorId) {
            throw new ApiException(HttpStatus.CONFLICT, "Invalid professor ID");
        }

        var duplicatedTag = tagRepository.existsByProjectIdAndTagValueId(data.projectId(), data.tagValueId());
        if (duplicatedTag) {
            throw new ApiException(HttpStatus.CONFLICT, "Tag already registered");
        }
    }
}
