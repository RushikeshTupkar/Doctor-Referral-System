package com.example.demo.exceptionHandler;

public class NotValid extends Throwable{
    public NotValid(String message){
        super(message);
    }
}
