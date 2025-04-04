package com.algonquincollege.team7.dto;

import com.algonquincollege.team7.model.TagValue;

public record TagListResponse(
        Long id,
        String tagValue,
        String tagType) {

    public static TagListResponse fromEntity(TagValue tagValue) {
        return new TagListResponse(tagValue.getId(), tagValue.getValue(), tagValue.getTagType().getName());
    }
}