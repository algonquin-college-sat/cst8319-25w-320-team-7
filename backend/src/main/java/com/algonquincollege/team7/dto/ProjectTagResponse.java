package com.algonquincollege.team7.dto;

import com.algonquincollege.team7.model.Tag;

public record ProjectTagResponse(Long id, String value) {

    public ProjectTagResponse(Tag tag) {
        this(tag.getId(), tag.getTagValue().getValue());
    }
}
