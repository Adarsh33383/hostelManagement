package com.example.hostel.Validation;

import org.springframework.stereotype.Component;
@Component
public interface Validator {

          public boolean idValidator(int StudentId);
        public boolean nameValidator(String StudentName);

        public boolean roomsValidator(int RoomNo);
       public boolean addressValidator(String Address);

       public boolean numberValidator(long PhoneNumber);


    }
