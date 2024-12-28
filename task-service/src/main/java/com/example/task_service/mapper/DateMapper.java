package com.example.task_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Mapper
public interface DateMapper {
    DateMapper INSTANCE = Mappers.getMapper(DateMapper.class);

    default LocalDate map(LocalDateTime dateTime) {
        return dateTime == null ? null : dateTime.toLocalDate();
    }

    default LocalDateTime map(LocalDate date) {
        return date == null ? null : date.atStartOfDay();
    }
}