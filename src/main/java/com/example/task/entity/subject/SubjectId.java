package com.example.task.entity.subject;

import com.example.task.entity.schoolyear.SchoolYearEntity;
import com.example.task.entity.term.TermEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectId implements Serializable {


    @Column(name = "term_subject_id")
    private Integer id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            @JoinColumn(name = "starting_year", referencedColumnName = "starting_year"),
            @JoinColumn(name = "finishing_year", referencedColumnName = "finishing_year"),
            @JoinColumn(name = "term_type", referencedColumnName = "term_type")
    })
    private TermEntity termEntity;

}
