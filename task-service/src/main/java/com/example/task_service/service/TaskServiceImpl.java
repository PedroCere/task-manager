package com.example.task_service.service;

import com.example.task_service.model.Task;
import com.example.task_service.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        if (task.getId() != null && taskRepository.existsById(task.getId())) {
            throw new IllegalArgumentException("Task with ID " + task.getId() + " already exists.");
        }
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task); // El ID será generado automáticamente por JPA
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Task taskToDelete) {
        if (taskToDelete == null || !taskRepository.existsById(taskToDelete.getId())) {
            throw new IllegalArgumentException("Task not found with ID: " + (taskToDelete != null ? taskToDelete.getId() : "null"));
        }
        taskRepository.deleteById(taskToDelete.getId());
        System.out.println("Task deleted with ID: " + taskToDelete.getId());
    }
    @Override
    public Task getTaskById(Long id) {
        System.out.println("Searching for Task with id: " + id);
        Task task = taskRepository.findTaskById(id);
        if (task == null) {
            System.out.println("Task not found: " + id);
        } else {
            System.out.println("Task found: " + task.getId());
        }
        return task;
    }


}
