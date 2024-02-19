package com.example.task.entity.event;

import com.example.task.entity.subject.SubjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject_event", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectEvent {

    @EmbeddedId
    private SubjectEventId id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            @JoinColumn(name = "starting_year", referencedColumnName = "starting_year"),
            @JoinColumn(name = "finishing_year", referencedColumnName = "finishing_year"),
            @JoinColumn(name = "term_type", referencedColumnName = "term_type"),
            @JoinColumn(name = "term_subject_id", referencedColumnName = "term_subject_id")
    })
    private SubjectEntity subject;
}
