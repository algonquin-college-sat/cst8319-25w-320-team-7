package com.algonquincollege.team7.model;

import com.algonquincollege.team7.dto.TagValueRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tag_value")
public class TagValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tag_type_id")
    private TagType tagType;

    private String value;

    public TagValue(@Valid TagValueRequest data, TagType tagType) {
        this.tagType = tagType;
        this.value = data.value();
    }

    public void updateFrom(TagValueRequest data, TagType tagType) {
        this.tagType = tagType;
        this.value = data.value();
    }
}
