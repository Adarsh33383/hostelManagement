package com.example.hostel.Validation;

import org.springframework.stereotype.Component;
@Component
public interface Validator {

          public boolean IdValidator(Integer StudentId);
        public boolean nameValidator(String StudentName);
        public boolean roomsValidator(Integer Rooms);
      // public boolean addressValidator(String Address);


    }
