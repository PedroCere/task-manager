package com.example.project_service.mappers;

import com.example.project_service.dto.ProjectDto;
import com.example.project_service.dto.ProjectRequestDto;
import com.example.project_service.dto.ProjectResponseDto;
import com.example.project_service.models.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ProjectMapper {

    Project toEntity(ProjectDto dto);

    ProjectDto toDto(Project user);

    List<ProjectDto> toListOfDto(List<Project> users);

    List<Project> toListOfEntity(List<ProjectDto> dtos);


}
