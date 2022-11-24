package com.example.hostel.controller;

import com.example.hostel.entity.StudentInfo;
import com.example.hostel.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api")
public class Controller {

    @Autowired
    public ServiceImpl service;
    @GetMapping("/student")
    private List<StudentInfo> getStudents(){
        return this.service.getStudents();
    }
    @PostMapping("/studentInfo/{studentId}")
    public StudentInfo getStudents(@PathVariable int studentId){
        return this.service.getStudents(studentId);
    }

    @PutMapping("/student/{StudentId}")
    public StudentInfo updateStudent(@PathVariable (value="StudentId")int StudentId, @RequestBody StudentInfo student ) {
        return this.service.updateStudent(StudentId, student);
    }

    @DeleteMapping("/student/{StudentId}")
    public StudentInfo deleteStudent(@PathVariable  String StudentId) {
        return this.service.deleteStudent(Integer.parseInt(StudentId));
    }

}