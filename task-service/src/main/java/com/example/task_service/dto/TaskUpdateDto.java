package com.example.task_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskUpdateDto {

    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
    private Long userId;
    private Long projectId;



}

