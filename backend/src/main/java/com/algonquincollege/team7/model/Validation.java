package com.algonquincollege.team7.model;

import com.algonquincollege.team7.dto.ValidationRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "project_validation")
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private User professor;

    @Column(name = "professor_feedback")
    private String professorFeedback;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Validation(@Valid ValidationRequest data, Project project, User professor) {
        this.project = project;
        this.professor = professor;
        this.professorFeedback = data.professorFeedback();
        this.createdAt = LocalDateTime.now();
    }

    public void updateFrom(ValidationRequest data) {
        this.professor = professor;
        this.professorFeedback = data.professorFeedback();
    }
}

