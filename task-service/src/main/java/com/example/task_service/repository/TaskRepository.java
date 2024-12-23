package com.example.task_service.repository;

import com.example.task_service.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

    Task findTaskById(Long id);
    @Transactional
    @Modifying
    @Query("DELETE FROM Task t WHERE t.userId = :userId")
    void deleteByUserId(@Param("userId") Long userId);
}
