package com.example.hostel.service;

import com.example.hostel.Validation.Validator;
import com.example.hostel.entity.StudentInfo;
import com.example.hostel.exception.InvalidEntryException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImpl {
    List<StudentInfo> studentList= new ArrayList<>();
    public Service(){

    }
    @Override
    public List<StudentInfo> displayAll() {
        return studentList;
    }

    StudentInfo student = new StudentInfo();
    @Autowired
    Validator validation ;

    public String addStudents(StudentInfo student) throws Exception{
        StudentInfo studentDetails = new StudentInfo();


        try {
            if (!validation.IdValidator(student.getStudentId()))
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

        }catch (InvalidEntryException e){
            return e.getMessage();
        }
        studentList.add(studentDetails);
        return "Student added";

    }

    @Override
    public StudentInfo getStudents(int StudentId){
        StudentInfo stud= null;
        for (StudentInfo studentinfo: studentList){
            if (studentinfo.getStudentId()==StudentId){
                stud=studentinfo;
                break;
            }
        }
        return stud;
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
                student1.setAddress(student.getAddress());
                s = student1;
                break;
            }
        }
        return s;
    }

}

