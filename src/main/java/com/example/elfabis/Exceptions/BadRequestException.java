package com.example.elfabis.Exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String errorMessage){
        super(errorMessage);
    }
}
