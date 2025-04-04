package com.algonquincollege.team7.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "project_tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "tag_value_id")
    private TagValue tagValue;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private User professor;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Tag(Project project, TagValue tagValue, User professor) {
        this.project = project;
        this.tagValue = tagValue;
        this.professor = professor;
        this.createdAt = LocalDateTime.now();
    }
}
