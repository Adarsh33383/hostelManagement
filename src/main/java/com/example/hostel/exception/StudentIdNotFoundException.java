package com.example.hostel.exception;

public class StudentIdNotFoundException extends RuntimeException {
    public StudentIdNotFoundException(String msg){
        super(msg);
    }
}
