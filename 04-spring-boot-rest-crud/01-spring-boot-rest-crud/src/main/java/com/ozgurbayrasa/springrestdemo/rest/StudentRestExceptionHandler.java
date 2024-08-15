package com.ozgurbayrasa.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // Add an exception handler.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // Create an instance of error response.
        StudentErrorResponse errorResponse = new StudentErrorResponse();

        // Set fields of error response.
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // Return response.
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Add an generic exception handler.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        // Create an instance of error response.
        StudentErrorResponse errorResponse = new StudentErrorResponse();

        // Set fields of error response.
        // We change status code to 'bad request'.
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        // Set a user-friendly message.
        errorResponse.setMessage("Please use integers in your request.");
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // Return response.
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
