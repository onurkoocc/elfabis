package com.example.elfabis.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
