package com.example.task_service.kafka;

import com.example.task_service.repository.TaskRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
public class TaskEventConsumer {

    private final TaskRepository taskRepository;

    public TaskEventConsumer(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @KafkaListener(topics = "user-deleted-topic", groupId = "task-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void onUserDeleted(Long userId) {
        System.out.println("Received user deletion event for userId: " + userId);


        taskRepository.deleteByUserId(userId);
        System.out.println("Tasks deleted for userId: " + userId);
    }

    @KafkaListener(topics = "project-deleted-topic", groupId = "task-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void onProjectDeleted(Long projectId) {
        System.out.println("Received user deletion event for projectId: " + projectId);


        taskRepository.deleteByProjectId(projectId);
        System.out.println("Tasks deleted for projectId: " + projectId);
    }
}
