package com.example.task.entity.schoolyear;

import com.example.task.entity.StudentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class SchoolYearId implements Serializable {


    @Column(name = "starting_year")
    private Integer startingYear;

    @Column(name = "finishing_year")
    private Integer finishingYear;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentId;

}
