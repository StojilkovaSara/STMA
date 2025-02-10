package com.example.task.service;

import com.example.task.entity.TaskEntity;
import com.example.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserAuthenticationService userAuthenticationService;

    public void addTask(String name, String description, int priority, LocalDate dueDate) {
        taskRepository.save(new TaskEntity(dueDate, name, description, priority, false, userAuthenticationService.getLoggedInUser()));
    }

    public List<TaskEntity> getUserTasks() {
        return userAuthenticationService.getLoggedInUser().getTasks();
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public void finishTask(Integer id) throws Exception {
        TaskEntity task = taskRepository.findById(id).orElseThrow(Exception::new);
        task.setDone(true);
        taskRepository.save(task);
    }
}
