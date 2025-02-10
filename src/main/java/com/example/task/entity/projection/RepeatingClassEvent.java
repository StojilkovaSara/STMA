package com.example.task.entity.projection;

import java.time.LocalDate;
import java.time.LocalTime;

public interface RepeatingClassEvent {
    String getSubjectName();

    String getEventName();

    String getEventType();

    LocalDate getEventStartingDate();

    LocalDate getEventEndingDate();

    String getEventDay();

    LocalTime getEventStartTime();

    LocalTime getEventEndTime();

    Integer getEventId();
}