package com.algonquincollege.team7.service;

import com.algonquincollege.team7.dto.ProjectListRequest;
import com.algonquincollege.team7.dto.ProjectListResponse;
import com.algonquincollege.team7.dto.ProjectListResponseWrapper;
import com.algonquincollege.team7.dto.ProjectRegistrationRequest;
import com.algonquincollege.team7.infra.exception.ApiException;
import com.algonquincollege.team7.model.Project;
import com.algonquincollege.team7.model.UserType;
import com.algonquincollege.team7.repository.ProjectRepository;
import com.algonquincollege.team7.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

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

    public ProjectListResponseWrapper getProjectsByOrganizationId(Long organizationId, ProjectListRequest request) {
        var organizationExists = userRepository.existsByIdAndType(organizationId, UserType.valueOf("ORGANIZATION"));
        if (!organizationExists) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Organization not found");
        }

        // 创建分页请求
        Pageable pageable = PageRequest.of(
                request.page(),
                request.size(),
                Sort.Direction.fromString(request.sortDirection()),
                request.sortBy()
        );

        // 根据请求参数过滤项目
        Page<Project> projectPage;
        if (request.semesterFilter() != null) {
            projectPage = projectRepository.findByOrganizationIdAndSemester(organizationId, request.semesterFilter(), pageable);
        } else {
            projectPage = projectRepository.findByOrganizationId(organizationId, pageable);
        }

        // 转换为DTO
        List<ProjectListResponse> projectResponses = projectPage.getContent().stream()
                .map(ProjectListResponse::fromProject)
                .collect(Collectors.toList());

        // 创建包装响应
        return new ProjectListResponseWrapper(
                projectResponses,
                projectPage.getNumber(),
                projectPage.getSize(),
                projectPage.getTotalElements(),
                projectPage.getTotalPages()
        );
    }
}