package com.example.hostel.exception;

public class InvalidEntryException extends RuntimeException{
    public InvalidEntryException (String exception ){
        super(exception);
    }
}
