package com.example.hostel.service;

import com.example.hostel.entity.StudentInfo;

import java.util.List;

public interface ServiceImpl {
    String addStudents(StudentInfo student);

    List<StudentInfo> displayAll();

    StudentInfo getStudentById(int StudentId);

    List<StudentInfo> getStudentByRoomNo(int RoomNo);

    String deleteStudent(int StudentId);

    StudentInfo updateStudent(int StudentId, StudentInfo student);
}
