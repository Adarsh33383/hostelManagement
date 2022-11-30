package com.example.hostel.service;

import com.example.hostel.entity.StudentInfo;
import com.example.hostel.exception.InvalidEntryException;
import com.example.hostel.exception.StudentIdNotFoundException;

import java.util.List;

public interface ServiceImpl {
    String addStudents(StudentInfo student)throws InvalidEntryException, StudentIdNotFoundException;
    List<StudentInfo> displayAll();
   StudentInfo getStudent(int StudentId);

   StudentInfo getStudents(int RoomNo);

    String deleteStudentInfo(int StudentId);
    String updateStudentInfo(int StudentId, StudentInfo student);
}
