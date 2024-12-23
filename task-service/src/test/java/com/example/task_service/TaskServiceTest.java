package com.example.task_service;

import com.example.task_service.model.Task;
import com.example.task_service.repository.TaskRepository;
import com.example.task_service.service.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskServiceImpl taskService;
    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testThatCreatesSuccessfully(){

        //Arrange
        Task task = new Task(2L,"tarea1","tarea muy dificil",null,null,2L,null,null);
        when(taskRepository.existsById(task.getId())).thenReturn(false);
        when(taskRepository.save(task)).thenReturn(task);

        //Act
         Task createdTask = taskService.createTask(task);

        //Assert
        verify(taskRepository,times(1)).existsById(createdTask.getId());
        verify(taskRepository,times(1)).save(createdTask);
        assertNotNull(createdTask);
    }

}
