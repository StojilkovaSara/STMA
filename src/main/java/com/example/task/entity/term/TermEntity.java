package com.example.task.entity.term;

import com.example.task.entity.schoolyear.SchoolYearEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "term", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TermEntity {

    @EmbeddedId
    private TermId termId;

    @Column(name = "term_start_date")
    private LocalDate startDate;

    @Column(name = "term_end_date")
    private LocalDate endDate;

}
