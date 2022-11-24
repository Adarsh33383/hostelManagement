package com.example.hostel.service;

import com.example.hostel.entity.StudentInfo;

import java.util.List;

public interface ServiceImpl {
    List<StudentInfo> getStudents();
   StudentInfo getStudents(int StudentId);
}
