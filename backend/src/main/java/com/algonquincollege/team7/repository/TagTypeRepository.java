package com.algonquincollege.team7.repository;

import com.algonquincollege.team7.model.TagType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagTypeRepository extends JpaRepository<TagType, Long> {

    boolean existsByName(String name);
}
