package com.example.task.entity.projection;

import java.time.LocalDate;
import java.time.LocalTime;


public interface ExamEvent {
    String getSubjectName();

    String getEventName();

    String getEventType();

    LocalDate getEventDate();

    LocalTime getEventStartTime();

    LocalTime getEventEndTime();

    Integer getEventId();
}



