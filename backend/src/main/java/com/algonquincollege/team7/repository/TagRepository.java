package com.algonquincollege.team7.repository;

import com.algonquincollege.team7.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    boolean existsByProjectIdAndTagValueId(Long projectId, Long tagValueId);
}
