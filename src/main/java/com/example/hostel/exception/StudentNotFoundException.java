package com.example.hostel.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String exception){
        super(exception);
    }
}
