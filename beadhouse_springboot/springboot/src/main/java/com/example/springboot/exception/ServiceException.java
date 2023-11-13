package com.example.springboot.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String msg, String s){
        super(msg);
    }
}
