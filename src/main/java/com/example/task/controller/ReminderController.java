package com.example.task.controller;

import com.example.task.service.ReminderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ReminderController {

    private final ReminderService reminderService;

    @GetMapping("/add/reminder/{id}")
    public String getAddReminderPage(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "reminder";
    }

    @PostMapping("/add/reminder")
    public String addReminder(@RequestParam(name = "id") Integer id,
                              @RequestParam(name = "minutes") Integer minutes,
                              @RequestParam(name = "repeat") boolean repeat) throws Exception {
        reminderService.addReminder(id, minutes, repeat);
        return "redirect:/";
    }
}
