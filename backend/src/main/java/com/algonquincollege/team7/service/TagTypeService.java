package com.algonquincollege.team7.service;

import com.algonquincollege.team7.dto.TagTypeRequest;
import com.algonquincollege.team7.infra.exception.ApiException;
import com.algonquincollege.team7.model.TagType;
import com.algonquincollege.team7.repository.TagTypeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TagTypeService {

    @Autowired
    private TagTypeRepository tagTypeRepository;

    public void registerTagType(@RequestBody @Valid TagTypeRequest data) {
        validateTagType(data);

        var tagType = new TagType(data.name());
        tagTypeRepository.save(tagType);
    }

    public void editTagType(@RequestBody @Valid TagTypeRequest data) {
        validateTagType(data);

        var tagType = tagTypeRepository.findById(data.id()).get();
        tagType.updateFrom(data.name());
        tagTypeRepository.save(tagType);
    }

    private void validateTagType(@RequestBody @Valid TagTypeRequest data) {
        var duplicatedTagType = tagTypeRepository.existsByName(data.name());

        if (duplicatedTagType) {
            throw new ApiException(HttpStatus.CONFLICT, "Tag type already registered");
        }
    }
}
