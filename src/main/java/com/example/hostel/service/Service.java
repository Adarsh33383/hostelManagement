package com.example.hostel.service;

import com.example.hostel.entity.StudentInfo;
import com.example.hostel.service.ServiceImpl;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImpl {
    List<StudentInfo> studentList= new ArrayList<>();
    public Service(){
        studentList.add(new StudentInfo(10,"Adarsh",101));
        studentList.add(new StudentInfo(11,"Abhilash",102));
        studentList.add(new StudentInfo(12,"Mahesh",103));
    }
    @Override
    public List<StudentInfo> getStudents() {
        return studentList;
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
                s = student1;
                break;
            }
        }
        return s;
    }

}

