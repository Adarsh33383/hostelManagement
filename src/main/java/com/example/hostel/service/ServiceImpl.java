package com.example.hostel.service;

import com.example.hostel.entity.StudentInfo;

import java.util.List;

public interface ServiceImpl {
    String addStudents(StudentInfo student)throws Exception;
    List<StudentInfo> displayAll();
   StudentInfo getStudents(int StudentId);

    StudentInfo deleteStudent(int StudentId);
    StudentInfo updateStudent(int StudentId, StudentInfo student);
}
