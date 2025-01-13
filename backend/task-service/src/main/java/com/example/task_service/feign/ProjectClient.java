package com.example.task_service.feign;

import com.example.task_service.dto.ProjectDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "project-service",url = "http://localhost:8083")
public interface ProjectClient {

    @GetMapping("/{projectId}")
    ResponseEntity<ProjectDto> getProjectById(@PathVariable Long projectId);

}
