package com.example.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "task", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;

    @Column(name = "task_due_date")
    private LocalDate dueDate;

    @Column(name = "task_name")
    private String name;

    @Column(name = "task_description")
    private String description;

    @Column(name = "task_priority")
    private Integer priority;

    @Column(name = "is_done")
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    public TaskEntity(String name, String description, Integer priority, boolean isDone, StudentEntity student) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
        this.student = student;
    }
    public TaskEntity(LocalDate dueDate, String name, String description, Integer priority, boolean isDone, StudentEntity student) {
        this.dueDate = dueDate;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
        this.student = student;
    }
}
