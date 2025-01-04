package com.example.comment_service.controllers;

import com.example.comment_service.dtos.RequestDto;
import com.example.comment_service.dtos.ResponseDto;
import com.example.comment_service.mappers.CommentMapper;
import com.example.comment_service.models.Comment;
import com.example.comment_service.servicies.CommentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.tokens.CommentToken;

import java.util.List;

@RestController
@RequestMapping(path = "/comments")
@Tag(name="Comment Controller", description = "comment handler API")
public class CommentController {

    private CommentMapper commentMapper;

    private CommentServiceImpl commentService;

    public CommentController(CommentMapper commentMapper, CommentServiceImpl commentService) {
        this.commentMapper = commentMapper;
        this.commentService = commentService;
    }

    @PostMapping
    @Operation(summary = "Create a comment")
    public ResponseEntity<ResponseDto> createProject(@RequestBody RequestDto dto){
        Comment comment = commentMapper.toEntity(dto);
        Comment savedComment = commentService.create(comment);
        ResponseDto responseDto = commentMapper.toDto(savedComment);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get All Comments")
    public ResponseEntity<List<ResponseDto>> getComments(){
        List<Comment> comments = commentService.getAll();
        List<ResponseDto> commentsDto = commentMapper.toListOfDto(comments);
        return new ResponseEntity<>(commentsDto,HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get comment by ID")
    public ResponseEntity<ResponseDto> getCommentById(@PathVariable Long id){
        Comment comment = commentService.getCommentById(id);
        ResponseDto responseDto = commentMapper.toDto(comment);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @GetMapping(path = "/user/{userId}")
    @Operation(summary = "Get comment by user ID")
    public ResponseEntity<List<ResponseDto>> getCommentByUserId(@PathVariable Long userId){
        List<Comment> comment = commentService.getAllCommentByUserId(userId);
        List<ResponseDto> responseDto = commentMapper.toListOfDto(comment);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @GetMapping(path = "/task/{taskId}")
    @Operation(summary = "Get comment by task ID")
    public ResponseEntity<List<ResponseDto>> getCommentByTaskId(@PathVariable Long taskId){
        List<Comment> comment = commentService.getAllCommentByTaskId(taskId);
        List<ResponseDto> responseDto = commentMapper.toListOfDto(comment);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "Update comment by ID")
    public ResponseEntity<ResponseDto> updateCommentById(@RequestBody RequestDto dto,@PathVariable Long id){
        Comment toUpdateComment = commentMapper.toEntity(dto);
        toUpdateComment.setId(id);
        Comment updatedComment = commentService.fullUpdate(toUpdateComment);
        ResponseDto responseDto = commentMapper.toDto(updatedComment);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    @Operation(summary = "Delete comment by Id")
    public void deleteCommentById(@PathVariable Long id){
        Comment commentToDelete = commentService.getCommentById(id);
        commentService.deleteComment(commentToDelete);
    }

    @DeleteMapping(path = "/user/{userId}")
    @Operation(summary = "Delete Comment By User ID")
    public void deleteCommentByUserId(@PathVariable Long userId){
        Comment commentToDelete = commentService.getCommentByUserId(userId);
        commentService.deleteComment(commentToDelete);
    }

    @DeleteMapping(path = "/task/{taskId}")
    @Operation(summary = "Delete comments using task ID")
    public void deleteCommentByTaskId(@PathVariable Long taskId){
        Comment commentToDelete = commentService.getCommentByTaskId(taskId);
        commentService.deleteComment(commentToDelete);
    }


}
