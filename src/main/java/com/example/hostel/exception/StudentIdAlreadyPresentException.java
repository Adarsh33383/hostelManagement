package com.example.hostel.exception;

public class StudentIdAlreadyPresentException extends RuntimeException {
    public StudentIdAlreadyPresentException(String msg) {
        super(msg);
    }
}
