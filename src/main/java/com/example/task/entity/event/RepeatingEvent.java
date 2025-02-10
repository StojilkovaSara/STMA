package com.example.task.entity.event;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "repeating_event", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RepeatingEvent {

    @EmbeddedId
    private NonRepeatingEventId id;

    @Column(name = "event_week_day")
    private String day;

    @Column(name = "repeats_every_n_weeks")
    private Integer repeat;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "ending_date")
    private LocalDate endingDate;



}
