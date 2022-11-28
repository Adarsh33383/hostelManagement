package com.example.hostel.Validation;

import com.example.hostel.service.Service;
import org.springframework.stereotype.Component;

@Component
public class ValidationImpl implements Validator {
        Service service = new Service();
    @Override
    public boolean IdValidator(Integer StudentId) {
        return StudentId>0;
    }
    @Override
    public boolean nameValidator(String StudentName) {
        return StudentName.length() >= 4;
    }

    @Override
    public boolean roomsValidator(Integer RoomNo) {
        return RoomNo>0;

    }

    @Override
//    public boolean addressValidator(String Address) {
//        return false;
//    }
    public boolean addressValidator(String address) {
        return address.matches("[A-Za-z]{3,20}$");
    }

}