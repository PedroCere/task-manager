package com.example.notification_service.mappers;

import com.example.notification_service.dtos.RequestDto;
import com.example.notification_service.dtos.ResponseDto;
import com.example.notification_service.models.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface NotificationMapper {

    Notification toEntity(RequestDto dto);

    ResponseDto toDto(Notification notification);

    List<ResponseDto> toListOfDto(List<Notification> notifications);



}
