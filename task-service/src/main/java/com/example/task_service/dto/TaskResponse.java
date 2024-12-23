package com.example.task_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
    private Long userId;


}
