package com.example.hostel.Validation;

import com.example.hostel.exception.InvalidEntryException;
import com.example.hostel.service.Service;
import org.springframework.stereotype.Component;

@Component
public class ValidationImpl implements Validator {
    Service service = new Service();

    @Override
    public int idValidator(int StudentId) {
        if (StudentId < 0)
            throw new InvalidEntryException("Enter valid StudentId");
        return StudentId;
    }

    @Override
    public String nameValidator(String StudentName) {
        if (StudentName.length() < 3)
            throw new InvalidEntryException("Enter Valid Name");
        return StudentName;
    }

    @Override
    public int roomsValidator(int RoomNo) {
        if (RoomNo < 0)
            throw new InvalidEntryException("Enter Valid Room Number");
        return RoomNo;
    }

    @Override
    public String addressValidator(String address) {
        if (!(address.matches("[A-Za-z]{3,20}$")))
            throw new InvalidEntryException("Enter Valid Address");
        return address;
    }

    @Override
    public long numberValidator(long number) {
        String numStr = String.valueOf(number);
        if (numStr.length() != 10)
            throw new InvalidEntryException("Enter Valid PhoneNumber");
        return number;
    }

}