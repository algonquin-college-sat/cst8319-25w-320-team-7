package com.algonquincollege.team7.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tag_type")
public class TagType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public TagType(String name) {
        this.name = name;
    }

    public void updateFrom(String name) {
        this.name = name;
    }
}
