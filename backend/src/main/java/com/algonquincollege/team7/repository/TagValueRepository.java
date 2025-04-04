package com.algonquincollege.team7.repository;

import com.algonquincollege.team7.model.TagValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TagValueRepository extends JpaRepository<TagValue, Long> {

    boolean existsByValueAndTagTypeId( String value, Long tagTypeId);

    @Query("SELECT t FROM TagValue t JOIN FETCH t.tagType ORDER BY t.tagType.name ASC")
    List<TagValue> findAllOrderedByTagType();
}
