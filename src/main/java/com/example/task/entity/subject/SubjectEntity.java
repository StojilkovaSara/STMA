package com.example.task.entity.subject;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject_at_term", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectEntity {

    @EmbeddedId
    private SubjectId id;

    @Column(name = "subject_name")
    private String name;
}
