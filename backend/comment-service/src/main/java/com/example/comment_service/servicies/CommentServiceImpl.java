package com.example.comment_service.servicies;

import com.example.comment_service.models.Comment;
import com.example.comment_service.repositories.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.getCommentById(id);
    }

    @Override
    public Comment fullUpdate(Comment toUpdateComment) {
        Comment existingComment = commentRepository.getCommentById(toUpdateComment.getId());

        Comment updatedComment = Comment.builder()
                .id(existingComment.getId())
                .userId(toUpdateComment.getUserId() != null ? toUpdateComment.getUserId() : existingComment.getUserId())
                .taskId(toUpdateComment.getTaskId() != null ? toUpdateComment.getTaskId() : existingComment.getTaskId())
                .content(toUpdateComment.getContent())
                .build();

        return commentRepository.save(updatedComment);
    }

    @Override
    public void deleteComment(Comment commentToDelete) {
        if (commentRepository.existsById(commentToDelete.getId())){
            commentRepository.delete(commentToDelete);
            System.out.println("Comment deleted Successfully");
        } else throw new EntityNotFoundException("Comment not Found");
    }

    @Override
    public Comment getCommentByUserId(Long userId) {
        if (commentRepository.getCommentByUserId(userId)!=null){
           return commentRepository.getCommentByUserId(userId);
        } else throw new EntityNotFoundException("Comment not Found");
    }

    @Override
    public Comment getCommentByTaskId(Long taskId) {
        if (commentRepository.getCommentByTaskId(taskId)!=null){
            return commentRepository.getCommentByTaskId(taskId);
        } else throw new EntityNotFoundException("Comment not Found");
    }

    @Override
    public List<Comment> getAllCommentByUserId(Long userId) {
        if (commentRepository.getAllCommentsByUserId(userId)!=null){
            return commentRepository.getAllCommentsByUserId(userId);
        } else throw new EntityNotFoundException("Comment not Found");
    }

    @Override
    public List<Comment> getAllCommentByTaskId(Long taskId) {
        if (commentRepository.getAllCommentsByTaskId(taskId)!=null){
            return commentRepository.getAllCommentsByTaskId(taskId);
        } else throw new EntityNotFoundException("Comment not Found");
    }
}
