package com.example.hostel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidEntryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  ErrorResponse InvalidEntryException(InvalidEntryException e){
        ErrorResponse response =new ErrorResponse();
        response.setMsgCode(HttpStatus.BAD_REQUEST.value());
        response.setMsg(e.getMessage());
        return response;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  ErrorResponse StudentNotFoundException(StudentNotFoundException e){
        ErrorResponse response = new ErrorResponse();
        response.setMsgCode(HttpStatus.NOT_FOUND.value());
        response.setMsg(e.getMessage());
        return response;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = StudentIdAlreadyPresentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  ErrorResponse StudentIdAlreadyPresentException(StudentIdAlreadyPresentException e){
        ErrorResponse response = new ErrorResponse();
        response.setMsgCode(HttpStatus.BAD_REQUEST.value());
        response.setMsg(e.getMessage());
        return response;
    }
}
