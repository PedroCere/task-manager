package com.example.notification_service.servicies;

import com.example.notification_service.mappers.NotificationMapper;
import com.example.notification_service.models.Notification;
import com.example.notification_service.respositories.NotificationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class NotificationServiceImpl implements NotificationService{

    private NotificationRepository notificationRepository;
    private NotificationMapper notificationMapper;

    @Autowired
    private NotificationServiceImpl(NotificationRepository notificationRepository,NotificationMapper notificationMapper){
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Notification create(Notification notification) {
          notification.setCreatedAt(LocalDate.now());
          notification.setUpdatedAt(LocalDate.now());
          return notificationRepository.save(notification);
       }

    @Override
    public Notification getById(Long id) {
        if (!notificationRepository.existsById(id)){
            throw new EntityNotFoundException("Notification Not Found");
        } else {
         return notificationRepository.findNotificationById(id);
        }
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getAllByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public Notification update(Notification notification) {
        Notification existingNotification = notificationRepository.findNotificationById(notification.getId());
        Notification updateNotification = Notification.builder()
                .id(existingNotification.getId())
                .message(notification.getMessage() != null ? notification.getMessage() : existingNotification.getMessage())
                .isRead(existingNotification.isRead())
                .userId(notification.getUserId() != null ? notification.getUserId() : existingNotification.getUserId())
                .createdAt(existingNotification.getCreatedAt())
                .updatedAt(LocalDate.now())
                .build();
        return updateNotification;
    }

    @Override
    public void deleteById(Notification notificationToDelete) {
        notificationRepository.deleteById(notificationToDelete.getId());
        System.out.println("Notification Deleted Successfully");
    }
    @Override
    public Notification markAsRead(Notification notificationToMark) {
        notificationToMark.setIsRead(true);
        Notification updatedNotification = notificationRepository.save(notificationToMark);
        System.out.println("Entidad actualizada: " + updatedNotification);
        return updatedNotification;
    }

    @Override
    public void markAllAsRead(Long userId) {
        List<Notification> notifications = notificationRepository.findByUserId(userId);
        notifications.forEach(notification -> {
            notification.setUpdatedAt(LocalDate.now());
            notification.setRead(true);
        });
        notificationRepository.saveAll(notifications);
    }

    @Override
    public void deleteAllByUser(Long userId) {
        notificationRepository.deleteByUserId(userId);
    }

}

