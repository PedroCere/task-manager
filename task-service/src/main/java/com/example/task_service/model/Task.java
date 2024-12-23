package com.example.task_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column
    private String status;

    @Column(name = "user_id")
    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
