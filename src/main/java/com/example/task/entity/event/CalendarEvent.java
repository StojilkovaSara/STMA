package com.example.task.entity.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "calendar_event", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_event_id")
    private Integer id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "event_type")
    private String type;

    @Column(name = "event_description")
    private String description;

    @Column(name = "event_start_time")
    private Time startTime;

    @Column(name = "event_end_time")
    private Time endTime;

    public CalendarEvent(String name, String type, String description, Time startTime, Time endTime) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
