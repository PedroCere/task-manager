package com.example.comment_service.repositories;

import com.example.comment_service.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    Comment getCommentById(Long id);
    Comment getCommentByUserId(Long userId);
    Comment getCommentByTaskId(Long taskId);
    List<Comment> getAllCommentsByUserId(Long userId);

    List<Comment> getAllCommentsByTaskId(Long taskId);


}
