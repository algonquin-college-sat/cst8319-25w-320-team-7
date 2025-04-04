package com.algonquincollege.team7.service;

import com.algonquincollege.team7.dto.TagListResponse;
import com.algonquincollege.team7.dto.TagValueRequest;
import com.algonquincollege.team7.infra.exception.ApiException;
import com.algonquincollege.team7.model.TagValue;
import com.algonquincollege.team7.repository.TagTypeRepository;
import com.algonquincollege.team7.repository.TagValueRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TagValueService {

    @Autowired
    private TagValueRepository tagValueRepository;

    @Autowired
    private TagTypeRepository tagTypeRepository;

    public void registerTagValue(@RequestBody @Valid TagValueRequest data) {
        validateTagValue(data);

        var tagType = tagTypeRepository.findById(data.tagTypeId()).get();
        var tagValue = new TagValue(data, tagType);

        tagValueRepository.save(tagValue);
    }

    public void editTagValue(@RequestBody @Valid TagValueRequest data) {
        validateTagValue(data);

        var tagValue = tagValueRepository.findById(data.id()).get();
        var tagType = tagTypeRepository.findById(data.tagTypeId()).get();

        tagValue.updateFrom(data, tagType);
        tagValueRepository.save(tagValue);
    }

    private void validateTagValue(@RequestBody @Valid TagValueRequest data) {
        var duplicatedTagValue = tagValueRepository.existsByValueAndTagTypeId(data.value(), data.tagTypeId());
        if (duplicatedTagValue) {
            throw new ApiException(HttpStatus.CONFLICT, "Tag value already registered");
        }

        var validTagValue = tagTypeRepository.existsById(data.tagTypeId());
        if (!validTagValue) {
            throw new ApiException(HttpStatus.CONFLICT, "Tag type is invalid");
        }
    }

    public List<TagListResponse> getTagList() {
        return tagValueRepository.findAllOrderedByTagType()
                .stream()
                .map(tag -> new TagListResponse(tag.getId(), tag.getValue(), tag.getTagType().getName()))
                .toList();
    }
}
