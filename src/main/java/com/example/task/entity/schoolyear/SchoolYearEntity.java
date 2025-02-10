package com.example.task.entity.schoolyear;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "school_year", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SchoolYearEntity {

    @EmbeddedId
    private SchoolYearId schoolYearId;

}
