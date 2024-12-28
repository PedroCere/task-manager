package com.example.notification_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private String message;
    private Boolean read;
    private Long userId;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
