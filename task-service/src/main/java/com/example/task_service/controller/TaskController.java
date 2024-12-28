package com.example.task_service.controller;

import com.example.task_service.dto.TaskCreateDto;
import com.example.task_service.dto.TaskResponse;
import com.example.task_service.dto.TaskUpdateDto;
import com.example.task_service.mapper.TaskMapper;
import com.example.task_service.model.Task;
import com.example.task_service.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/task")
public class TaskController {
    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskService taskService;

    @PostMapping
    private ResponseEntity<TaskCreateDto> createTask(@Valid @RequestBody TaskCreateDto dto) {
        System.out.println("DTO recibido: " + dto);
        Task task = taskMapper.toEntity(dto);
        System.out.println("Entidad creada: " + task);
        Task savedTask = taskService.createTask(task);
        TaskCreateDto savedTaskDto = taskMapper.toDto(savedTask);
        System.out.println("DTO guardado: " + savedTaskDto);
        return new ResponseEntity<>(savedTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskCreateDto>> getTasks(){
        List<Task> tasks = taskService.getAllTasks();
        List<TaskCreateDto> taskResponse = taskMapper.toListOfDto(tasks);
        return new ResponseEntity<>(taskResponse,HttpStatus.OK);
     }

     @GetMapping(path = "/{id}")
     public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id){
        Task task = taskService.getTaskById(id);
        TaskResponse taskResponse = taskMapper.toResponseDto(task);
        return new ResponseEntity<>(taskResponse,HttpStatus.OK);
     }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @RequestBody @Valid TaskUpdateDto taskUpdateDto) {
        Task taskToUpdate = taskMapper.toEntityUpdate(taskUpdateDto);
        taskToUpdate.setId(id);
        Task updatedTask = taskService.fullUpdateTask(taskToUpdate);
        TaskResponse response = taskMapper.toResponseDto(updatedTask);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping(path = "/{id}")
     public void deleteTask(@PathVariable Long id){
         Task taskToDelete = taskService.getTaskById(id);
         taskService.deleteTask(taskToDelete);
         System.out.println("Task Deleted Successfully");
     }








}
