package com.example.project_service.controllers;

import com.example.project_service.dto.ProjectDto;
import com.example.project_service.mappers.ProjectMapper;
import com.example.project_service.models.Project;
import com.example.project_service.servicies.ProjectServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectMapper projectMapper;

    private ProjectServiceImpl projectService;

    @Autowired
    private ProjectController(ProjectMapper projectMapper, ProjectServiceImpl projectService){
        this.projectMapper = projectMapper;
        this.projectService = projectService;
    }

    @PostMapping
    @Operation(summary = "Create a Project")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto dto){

        Project project = projectMapper.toEntity(dto);
        Project savedProject = projectService.saveProject(project);
        ProjectDto projectResponse = projectMapper.toDto(savedProject);
        return new ResponseEntity<>(projectResponse, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get All Projects")
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        List<Project> projects = projectService.getAll();
        List<ProjectDto> projectsDto = projectMapper.toListOfDto(projects);
        return new ResponseEntity<>(projectsDto,HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get a Project By ID")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long id){
        Project project = projectService.getById(id);
        ProjectDto projectDto = projectMapper.toDto(project);
        return new ResponseEntity<>(projectDto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Full Update Project")
    public ResponseEntity<ProjectDto> updateProject(
            @PathVariable Long id,
            @RequestBody @Valid ProjectDto projectDto) {
        Project projectUpdate = projectMapper.toEntity(projectDto);
        projectUpdate.setId(id);
        Project updateProject = projectService.fullUpdateProject(projectUpdate);
        ProjectDto response = projectMapper.toDto(updateProject);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete a Project Using ID")
    public void deleteProject(@PathVariable Long id){
        Project projectToDelete = projectService.getById(id);
        projectService.deleteProject(projectToDelete);
    }


}
