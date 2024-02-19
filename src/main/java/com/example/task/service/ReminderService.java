package com.example.task.service;

import com.example.task.entity.event.CalendarEvent;
import com.example.task.entity.reminder.ReminderEntity;
import com.example.task.repository.ReminderRepository;
import com.example.task.repository.event.CalendarEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReminderService {

    private final CalendarEventRepository calendarEventRepository;
    private final ReminderRepository reminderRepository;

    public void addReminder(Integer id, Integer minutes, boolean repeat) throws Exception {
        CalendarEvent calendarEvent = calendarEventRepository.findById(id).orElseThrow(Exception::new);
        ReminderEntity reminderEntity = new ReminderEntity(calendarEvent, minutes, repeat);
        reminderRepository.save(reminderEntity);
    }
}
