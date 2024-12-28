package com.example.project_service.servicies;

import com.example.project_service.exceptions.ProjectAlreadyExistsException;
import com.example.project_service.exceptions.ProjectNotFoundException;
import com.example.project_service.models.Project;
import com.example.project_service.repositories.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    private KafkaTemplate<String, Long> kafkaTemplate;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, KafkaTemplate<String,Long> kafkaTemplate){
        this.projectRepository = projectRepository;
        this.kafkaTemplate = kafkaTemplate;
    }



    @Override
    public Project saveProject(Project project) {
        if (project.getId() != null && projectRepository.existsById(project.getId())) {
            throw new ProjectAlreadyExistsException("Project with ID " + project.getId() + " already exists.");
        }
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.findProjectById(id);
    }

    @Override
    public Project fullUpdateProject(Project project) {
        Project existingProject = projectRepository.findById(project.getId())
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + project.getId()));

        Project updatedProject = Project.builder()
                .id(existingProject.getId())
                .name(project.getName())
                .description(project.getDescription() != null ? project.getDescription() : existingProject.getDescription())
                .userId(project.getUserId() != null ? project.getUserId() : existingProject.getUserId())
                .createdAt(existingProject.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();

        return projectRepository.save(updatedProject);
    }

    @Override
    public void deleteProject(Project projectToDelete) {
        Project existingProject = projectRepository.findById(projectToDelete.getId())
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + projectToDelete.getId()));

        projectRepository.deleteById(projectToDelete.getId());
        System.out.println("Project deleted successfully");

        try {
            System.out.println("Sending event to Kafka: project-deleted-topic, id=" + projectToDelete.getId());
            kafkaTemplate.send("project-deleted-topic", projectToDelete.getId());
            System.out.println("Event published to Kafka for project ID: " + projectToDelete.getId());
        } catch (Exception e) {
            System.err.println("Failed to publish Kafka event: " + e.getMessage());
        }
    }


}
