package com.example.task.entity;

import com.example.task.entity.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "dashboard", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DashboardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dashboard_id")
    private Integer dashboardId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentEntity studentId;


    @Column(name = "dashboard_date", nullable = false)
    private LocalDate dashboardDate;

    public DashboardEntity(StudentEntity studentId, LocalDate dashboardDate) {
        this.studentId = studentId;
        this.dashboardDate = dashboardDate;
    }
}
