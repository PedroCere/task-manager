package com.example.project_service.servicies;

import com.example.project_service.models.Project;

import java.util.List;

public interface ProjectService {
    Project saveProject(Project project);

    List<Project> getAll();

    Project getById(Long id);

    Project fullUpdateProject(Project project);

    void deleteProject(Project projectToDelete);
}
