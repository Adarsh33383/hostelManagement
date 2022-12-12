package com.example.hostel.service;

import com.example.hostel.Validation.Validator;
import com.example.hostel.entity.StudentInfo;
import com.example.hostel.exception.StudentIdAlreadyPresentException;
import com.example.hostel.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImpl {
    List<StudentInfo> studentList = new ArrayList<>();

    public List<StudentInfo> getStudentList() {
        return studentList;
    }

    public Service() {
    }

    StudentInfo student = new StudentInfo();
    @Autowired
    Validator validation;

    public String addStudents(StudentInfo student) {
        StudentInfo studentDetails = new StudentInfo();
        specialCheck(student.getStudentId());
        studentDetails.setStudentId(validation.idValidator(student.getStudentId()));
        studentDetails.setStudentName(validation.nameValidator(student.getStudentName()));
        studentDetails.setRoomNo(validation.roomsValidator(student.getRoomNo()));
        studentDetails.setAddress(validation.addressValidator(student.getAddress()));
        studentDetails.setPhoneNumber(validation.numberValidator(student.getPhoneNumber()));
        studentList.add(studentDetails);
        return studentDetails + "Student added";
    }


    @Override
    public List<StudentInfo> displayAll() {
        if (studentList.size() == 0) {
            throw new StudentNotFoundException("No students present in list");
        }
        return studentList;
    }


    @Override
    public StudentInfo getStudentById(int StudentId) {
        for (StudentInfo studentinfo : studentList) {
            if (studentinfo.getStudentId() == StudentId) {
                return studentinfo;
            }
        }
        throw new StudentNotFoundException("Student not present in list " + StudentId);
    }


    public List<StudentInfo> getStudentByRoomNo(int RoomNo) {
        List<StudentInfo> result = new ArrayList<>();
        for (StudentInfo studentInfo : studentList) {
            if (studentInfo.getRoomNo() == RoomNo)
//                return studentInfo; //todo
                result.add(studentInfo);
            else throw new StudentNotFoundException("Student not present in list " + RoomNo);
        }
        return result;
}


    @Override
    public String deleteStudent(int StudentId) {
        StudentInfo studentInfo = null;
        for (StudentInfo student : studentList) {
            if (student.getStudentId() == StudentId) {
                studentInfo = student;
            }
        }
        if (studentInfo == null) {
            throw new StudentNotFoundException("Student not found");
        }
        studentList.remove(studentInfo);
        return studentInfo + " :Student deleted.";
    }


    public StudentInfo updateStudent(int StudentId, StudentInfo student) {
        validation.idValidator(StudentId);
        for (StudentInfo student1 : studentList) {
            if (student1.getStudentId() == StudentId) {
                student1.setStudentId(validation.idValidator(student.getStudentId()));
                student1.setStudentName(validation.nameValidator(student.getStudentName()));
                student1.setRoomNo(validation.roomsValidator(student.getRoomNo()));
                student1.setPhoneNumber(validation.numberValidator(student.getPhoneNumber()));
                student1.setAddress(validation.addressValidator(student.getAddress()));
                return student;
            }
        }
        throw new StudentNotFoundException("Student not found");
    }


    public void specialCheck(int StudentId) {
        for (StudentInfo studentInfo : getStudentList()) {
            if (studentInfo.getStudentId() == StudentId)
                throw new StudentIdAlreadyPresentException("StudentId already present");
        }
    }
}

