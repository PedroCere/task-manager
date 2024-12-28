package com.example.project_service.exceptions;

public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(String message){
        super(message);
    }

}