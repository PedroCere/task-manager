package com.example.comment_service.servicies;

import com.example.comment_service.models.Comment;

import java.util.List;

public interface CommentService {
    Comment create(Comment comment);

    List<Comment> getAll();

    Comment getCommentById(Long id);

    Comment fullUpdate(Comment toUpdateComment);

    void deleteComment(Comment commentToDelete);

    Comment getCommentByUserId(Long userId);

    Comment getCommentByTaskId(Long taskId);

    List<Comment> getAllCommentByUserId(Long userId);

    List<Comment> getAllCommentByTaskId(Long taskId);
}
