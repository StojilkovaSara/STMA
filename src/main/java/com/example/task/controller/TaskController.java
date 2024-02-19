package com.example.task.controller;

import com.example.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/add/task")
    public String getAddTaskPage() {
        return "task/form";
    }

    @PostMapping("/add/task")
    public String addTask(@RequestParam(name = "name") String name,
                          @RequestParam(name = "description") String description,
                          @RequestParam(name = "priority") int priority,
                          @RequestParam(name = "dueDate") LocalDate dueDate) {
        taskService.addTask(name, description, priority, dueDate);
        return "redirect:/task";
    }

    @GetMapping("/task")
    public String getTaskPage(Model model) {
        model.addAttribute("tasks", taskService.getUserTasks());
        return "task/list";
    }

    @PostMapping("/finish/task/{id}")
    public String finishTask(@PathVariable(name = "id") Integer id) throws Exception {
        taskService.finishTask(id);
        return "redirect:/task";
    }

    @PostMapping("/delete/task/{id}")
    public String deleteTask(@PathVariable(name = "id") Integer id) {
        taskService.deleteTask(id);
        return "redirect:/task";
    }
}
