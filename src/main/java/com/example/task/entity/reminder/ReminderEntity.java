package com.example.task.entity.reminder;

import com.example.task.entity.event.CalendarEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reminder", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReminderEntity {

    @ManyToOne
    @JoinColumn(name = "calendar_event_id", referencedColumnName = "calendar_event_id")
    private CalendarEvent calendarEvent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Integer id;

    @Column(name = "minutes_before_event")
    private Integer minutesBeforeEvent;

    @Column(name = "r_flag")
    private boolean repeat;

    public ReminderEntity(CalendarEvent calendarEvent, Integer minutesBeforeEvent, boolean repeat) {
        this.calendarEvent = calendarEvent;
        this.minutesBeforeEvent = minutesBeforeEvent;
        this.repeat = repeat;
    }
}
