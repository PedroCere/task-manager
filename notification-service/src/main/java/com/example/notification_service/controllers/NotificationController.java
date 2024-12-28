package com.example.notification_service.controllers;


import com.example.notification_service.dtos.RequestDto;
import com.example.notification_service.dtos.ResponseDto;
import com.example.notification_service.mappers.NotificationMapper;
import com.example.notification_service.models.Notification;
import com.example.notification_service.respositories.NotificationRepository;
import com.example.notification_service.servicies.NotificationService;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService notificationService;
    private NotificationMapper notificationMapper;

    @Autowired
    private NotificationController(NotificationService notificationService,NotificationMapper notificationMapper){
        this.notificationMapper = notificationMapper;
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createNotification(@RequestBody RequestDto requestDto) {

        Notification notification = notificationMapper.toEntity(requestDto);

        Notification createdNotification = notificationService.create(notification);

        ResponseDto responseDto = notificationMapper.toDto(createdNotification);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAllNotifications(){
        List<Notification> notifications = notificationService.getAll();
        List<ResponseDto> responseDtoList = notificationMapper.toListOfDto(notifications);
        return new ResponseEntity<>(responseDtoList,HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseDto> getNotificationById(@PathVariable Long id){
        Notification notification = notificationService.getById(id);
        ResponseDto responseDto = notificationMapper.toDto(notification);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<List<ResponseDto>> getNotificationByUserId(@PathVariable Long userId){
        List<Notification> notifications = notificationService.getAllByUserId(userId);
        List<ResponseDto> responseDtoList = notificationMapper.toListOfDto(notifications);
        return new ResponseEntity<>(responseDtoList,HttpStatus.OK);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<ResponseDto> updateNotification(@PathVariable Long id,@RequestBody RequestDto requestDto){
        Notification notification = notificationMapper.toEntity(requestDto);
        notification.setId(id);
        Notification updatedNotification = notificationService.update(notification);
        ResponseDto responseDto = notificationMapper.toDto(updatedNotification);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteNotification(@PathVariable Long id){
        Notification notificationToDelete = notificationService.getById(id);
        notificationService.deleteById(notificationToDelete);
    }
    @PatchMapping(path = "/{id}/read")
    public ResponseEntity<ResponseDto> markNotificationAsRead(@PathVariable Long id) {
        Notification notificationToMark = notificationService.getById(id);
        System.out.println("Notificación encontrada: " + notificationToMark);

        Notification notificationUpdated = notificationService.markAsRead(notificationToMark);
        System.out.println("Notificación actualizada: " + notificationUpdated);

        ResponseDto responseDto = notificationMapper.toDto(notificationUpdated);
        System.out.println("DTO de respuesta: " + responseDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @PatchMapping("/user/{userId}/read")
    public ResponseEntity<String> markAllAsRead(@PathVariable Long userId) {
        notificationService.markAllAsRead(userId);
        return ResponseEntity.ok("All notifications marked as read for user " + userId);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteAllByUser(@PathVariable Long userId) {
        notificationService.deleteAllByUser(userId);
        return ResponseEntity.noContent().build();
    }





}
