package com.example.project_service.exceptions;

public class ProjectAlreadyExistsException extends RuntimeException{

    public ProjectAlreadyExistsException(String message){
        super(message);
    }

}
