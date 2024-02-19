package com.example.task.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "student", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "s_first_name", nullable = false)
    private String firstName;

    @Column(name = "s_last_name")
    private String lastName;

    @Column(name = "s_password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "student")
    private List<TaskEntity> tasks;

    public StudentEntity(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
}