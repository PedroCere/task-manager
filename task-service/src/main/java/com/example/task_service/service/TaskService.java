package com.example.task_service.service;

import com.example.task_service.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);

    List<Task> getAllTasks();

    void deleteTask(Task taskToDelete);

    Task getTaskById(Long id);
}
