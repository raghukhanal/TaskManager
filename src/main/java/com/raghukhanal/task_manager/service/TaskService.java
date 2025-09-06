package com.raghukhanal.task_manager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import com.raghukhanal.task_manager.model.Task;

@Service
public class TaskService {
    private Map<Long, Task> taskRepo = new HashMap<>();
    private AtomicLong idGenerator = new AtomicLong();

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskRepo.values());
    }
    
    public Task addTask(String title) {
        Long id = idGenerator.incrementAndGet();
        Task newTask = new Task(id, title, false);
        taskRepo.put(id, newTask);
        return newTask;
    }

    public Task markCompleted(Long id) {
        Task task = taskRepo.get(id);
        if (task != null) {
            task.setCompleted(true);
        }
        return task;
    }
}
