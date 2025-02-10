package com.example.task.entity.event;

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
public class SubjectEventId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "calendar_event_id", referencedColumnName = "calendar_event_id")
    private CalendarEvent calendarEvent;

}