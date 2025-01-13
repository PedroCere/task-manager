package com.example.task_service.mapper;

import com.example.task_service.dto.TaskCreateDto;
import com.example.task_service.dto.TaskResponse;
import com.example.task_service.dto.TaskUpdateDto;
import com.example.task_service.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        uses = {DateMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface TaskMapper {

    @Mapping(source = "title", target = "title") // MapStruct infers this automatically unless overridden
    @Mapping(source = "description", target = "description")
    @Mapping(source = "dueDate", target = "dueDate")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "projectId", target = "projectId")
    @Mapping(source = "status", target = "status")
    Task toEntity(TaskCreateDto dto);

    @Mapping(source = "dueDate", target = "dueDate")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "projectId", target = "projectId")
    @Mapping(source = "status", target = "status")
    TaskCreateDto toDto(Task task);

    TaskResponse toResponseDto(Task task);

    TaskUpdateDto toUpdateDto(Task task);


    Task toEntityResponse(TaskResponse responseDto);

    Task toEntityUpdate(TaskUpdateDto updateDto);


    List<TaskCreateDto> toListOfDto(List<Task> tasks);

    List<Task> toListOfEntity(List<TaskCreateDto> dtos);
}


