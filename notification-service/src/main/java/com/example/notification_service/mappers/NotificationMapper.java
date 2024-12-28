package com.example.notification_service.mappers;

import com.example.notification_service.dtos.RequestDto;
import com.example.notification_service.dtos.ResponseDto;
import com.example.notification_service.models.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface NotificationMapper {

    @Mapping(source = "isRead", target = "isRead")
    ResponseDto toDto(Notification notification);

    Notification toEntity(RequestDto dto);

    List<ResponseDto> toListOfDto(List<Notification> notifications);


}
