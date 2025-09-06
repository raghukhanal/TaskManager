package com.raghukhanal.task_manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.raghukhanal.task_manager.service.TaskService;
import com.raghukhanal.task_manager.model.Task;


@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Map<String, String> body) {
        return taskService.addTask(body.get("title"));
    }

    @PutMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id) {
        return taskService.markCompleted(id);
    }
}
