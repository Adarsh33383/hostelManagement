package com.example.hostel.Validation;

import org.springframework.stereotype.Component;

@Component
public class ValidationImpl implements Validator {

    @Override
    public boolean IdValidator(Integer StudentId) {
        return StudentId>0;
    }
    @Override
    public boolean nameValidator(String StudentName) {
        return StudentName.length() >= 4;
    }
    @Override
    public boolean roomsValidator(Integer Rooms) {
        return Rooms>0;

    }
    public boolean addressValidator(String address) {
        return address.matches("[A-Za-z]{3,20}$");
    }

}