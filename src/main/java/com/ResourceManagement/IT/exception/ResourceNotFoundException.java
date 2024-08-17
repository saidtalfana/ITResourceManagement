package com.ResourceManagement.IT.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException( String message){
        super(message);
    }
}
