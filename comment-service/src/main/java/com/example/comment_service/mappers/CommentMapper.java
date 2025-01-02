package com.example.comment_service.mappers;

import com.example.comment_service.dtos.RequestDto;
import com.example.comment_service.dtos.ResponseDto;
import com.example.comment_service.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface CommentMapper {

    ResponseDto toDto(Comment comment);
    Comment toEntity(RequestDto dto);
    List<ResponseDto> toListOfDto(List<Comment> tasks);

}