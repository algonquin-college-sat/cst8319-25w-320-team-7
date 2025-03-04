package com.algonquincollege.team7.repository;

import com.algonquincollege.team7.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
