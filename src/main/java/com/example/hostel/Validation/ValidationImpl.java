package com.example.hostel.Validation;

import com.example.hostel.service.Service;
import org.springframework.stereotype.Component;

@Component
public class ValidationImpl implements Validator {
    Service service = new Service();

    @Override
    public boolean idValidator(int StudentId) {
        return StudentId > 0;
    }

    @Override
    public boolean nameValidator(String StudentName) {
        return StudentName.length() >= 3;
    }

    @Override
    public boolean roomsValidator(int RoomNo) {
        return RoomNo > 0;

    }

    @Override
    public boolean addressValidator(String address) {
        return address.matches("[A-Za-z]{3,20}$");
    }

    @Override
    public boolean numberValidator(long number) {
        String numStr = String.valueOf(number);
        return numStr.length() == 10;
    }

}