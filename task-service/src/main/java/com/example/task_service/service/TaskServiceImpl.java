package com.example.task_service.service;

import com.example.task_service.model.Task;
import com.example.task_service.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        if (task.getId() != null && taskRepository.existsById(task.getId())) {
            throw new IllegalArgumentException("Task with ID " + task.getId() + " already exists.");
        }
        task.setCreatedAt(LocalDate.now());
        task.setUpdatedAt(LocalDate.now());
        return taskRepository.save(task);
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

    @Override
    public Task fullUpdateTask(Task task) {
        Task existingTask = taskRepository.findById(task.getId())
                .orElseThrow(() -> new EntityNotFoundException("Task not found with ID: " + task.getId()));

        Task updatedTask = Task.builder()
                .id(existingTask.getId())
                .title(task.getTitle() != null ? task.getTitle() : existingTask.getTitle())
                .description(task.getDescription() != null ? task.getDescription() : existingTask.getDescription())
                .status(task.getStatus() != null ? task.getStatus() : existingTask.getStatus())
                .dueDate(task.getDueDate() != null ? task.getDueDate() : existingTask.getDueDate())
                .userId(task.getUserId() != null ? task.getUserId() : existingTask.getUserId())
                .projectId(task.getProjectId() != null ? task.getProjectId() : existingTask.getProjectId())
                .createdAt(existingTask.getCreatedAt())
                .updatedAt(LocalDate.now())
                .build();

        return taskRepository.save(updatedTask);
    }


}
