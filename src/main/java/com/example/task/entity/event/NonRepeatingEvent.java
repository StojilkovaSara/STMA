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
@Table(name = "non_repeating_event", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NonRepeatingEvent {

    @EmbeddedId
    private NonRepeatingEventId id;

    @Column(name = "event_date")
    private LocalDate date;

}
