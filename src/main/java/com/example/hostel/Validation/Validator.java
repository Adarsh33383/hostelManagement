package com.example.hostel.Validation;

import org.springframework.stereotype.Component;

@Component
public interface Validator {

    public int idValidator(int StudentId);

    public String nameValidator(String StudentName);

    public int roomsValidator(int RoomNo);

    public String addressValidator(String Address);

    public long numberValidator(long PhoneNumber);


}
