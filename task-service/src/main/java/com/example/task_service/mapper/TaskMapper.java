package com.example.task_service.mapper;

import com.example.task_service.dto.TaskCreateDto;
import com.example.task_service.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface TaskMapper {

    Task toEntity(TaskCreateDto dto);

    TaskCreateDto toDto(Task user);

    List<TaskCreateDto> toListOfDto(List<Task> users);

    List<Task> toListOfEntity(List<TaskCreateDto> dtos);
}


