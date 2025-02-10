package com.example.task.entity.term;

import com.example.task.entity.StudentEntity;
import com.example.task.entity.schoolyear.SchoolYearEntity;
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
public class TermId implements Serializable {


    @Column(name = "term_type")
    private String termType;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            @JoinColumn(name = "starting_year", referencedColumnName = "starting_year"),
            @JoinColumn(name = "finishing_year", referencedColumnName = "finishing_year")
    })
    private SchoolYearEntity schoolYear;

}
