package com.example.hostel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentIdAlreadyPresentException extends RuntimeException {
    public StudentIdAlreadyPresentException(String msg) {
        super(msg);
    }
}
