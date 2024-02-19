package com.example.task.entity.event;

import com.example.task.entity.term.TermEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class NonRepeatingEventId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "calendar_event_id", referencedColumnName = "calendar_event_id")
    private CalendarEvent calendarEvent;

    public NonRepeatingEventId(CalendarEvent calendarEvent) {
        this.calendarEvent = calendarEvent;
    }

    public NonRepeatingEventId() {

    }
}
