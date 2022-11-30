package com.example.hostel.service;

import com.example.hostel.Validation.Validator;
import com.example.hostel.entity.StudentInfo;
import com.example.hostel.exception.InvalidEntryException;
import com.example.hostel.exception.StudentIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImpl {
    List<StudentInfo> studentList= new ArrayList<>();

    public List<StudentInfo> getStudentList() {
        return studentList;
    }

    public Service(){

    }
    @Override
    public List<StudentInfo> displayAll() {
        return studentList;
    }

    StudentInfo student = new StudentInfo();
    @Autowired
    Validator validation ;

    public String addStudents(StudentInfo student) {
        StudentInfo studentDetails = new StudentInfo();

            if (specialCheck(student.getStudentId()))
                throw new StudentIdNotFoundException("StudentId already present");

            if (!validation.idValidator(student.getStudentId()))
                throw new InvalidEntryException("Enter Valid Id");
            studentDetails.setStudentId(student.getStudentId());

            if (!validation.nameValidator(student.getStudentName()))
                throw new InvalidEntryException("Enter Valid Name");
            studentDetails.setStudentName(student.getStudentName());

            if (!validation.roomsValidator(student.getRoomNo()))
                throw new InvalidEntryException("Enter Valid Room Number");
            studentDetails.setRoomNo(student.getRoomNo());

            if (!validation.addressValidator(student.getAddress()))
                throw new InvalidEntryException("Enter Valid Address");
            studentDetails.setAddress(student.getAddress());

            if (!validation.numberValidator(student.getPhoneNumber()))
                throw new InvalidEntryException("Enter Valid PhoneNumber");
            studentDetails.setPhoneNumber(student.getPhoneNumber());


        studentList.add(studentDetails);
        return "Student added";

    }

    @Override
    public StudentInfo getStudent(int StudentId){
        StudentInfo stud= null;
        for (StudentInfo studentinfo: studentList){
            if (studentinfo.getStudentId()==StudentId){
                stud=studentinfo;
                break;
            }
        }
        return stud;
    }
    public StudentInfo getStudents(int RoomNo){
        StudentInfo studInfo= null;
        for (StudentInfo studentInfo: studentList) {
            if (studentInfo.getRoomNo()==RoomNo){
                studInfo=studentInfo;
                break;
            }
        }
        return studInfo;
    }



    @Override
    public StudentInfo deleteStudent(int StudentId) {
        StudentInfo st = null;
        for (StudentInfo student : studentList) {
            if (student.getStudentId() == StudentId) {
                st = student ;
                studentList.remove(student);
                break;
            }
        }
        return st;
    }


    public StudentInfo updateStudent(int StudentId, StudentInfo student) {
        StudentInfo s = null;
        for (StudentInfo student1 : studentList) {
            if (student1.getStudentId() == StudentId) {
                student1.setStudentName(student.getStudentName());
                student1.setRoomNo(student.getRoomNo());
                s = student1;
                break;
            }
        }
        return s;
    }
    public boolean specialCheck(int StudentId) {
        for (StudentInfo studentInfo : getStudentList()) {
            if (studentInfo.getStudentId() == StudentId)
                return true;
        }
        return false;
    }

}

