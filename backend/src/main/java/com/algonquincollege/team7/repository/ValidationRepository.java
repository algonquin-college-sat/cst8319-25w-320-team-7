package com.algonquincollege.team7.repository;

import com.algonquincollege.team7.model.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
    Optional<Validation> findByProjectId(Long projectId);
}
