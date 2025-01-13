package com.example.notification_service.servicies;

import com.example.notification_service.models.Notification;

import java.util.List;

public interface NotificationService {
    Notification create(Notification notification);

    Notification getById(Long id);

    List<Notification> getAll();

    List<Notification> getAllByUserId(Long id);

    Notification update(Notification notification);

    void deleteById(Notification notificationToDelete);

    Notification markAsRead(Notification notificationToMark);

    void markAllAsRead(Long userId);

    void deleteAllByUser(Long userId);
}
