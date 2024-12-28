package com.example.notification_service.respositories;

import com.example.notification_service.dtos.ResponseDto;
import com.example.notification_service.models.Notification;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long>{
    Notification findNotificationById(Long id);
    List<Notification> findByUserId(Long userId);

    @Modifying
    @Query("DELETE FROM Notification n WHERE n.userId = :userId")
    void deleteByUserId(Long userId);
}
