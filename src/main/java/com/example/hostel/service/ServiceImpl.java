package com.example.hostel.service;

import com.example.hostel.entity.StudentInfo;

import java.util.List;

public interface ServiceImpl {
    String addStudents(StudentInfo student)throws Exception;
    List<StudentInfo> displayAll();
   StudentInfo getStudents(int StudentId);

    String deleteStudentInfo(int StudentId);
    String updateStudentInfo(int StudentId, StudentInfo student);
}
