package com.ozgurbayrasa.springrestdemo.rest;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
