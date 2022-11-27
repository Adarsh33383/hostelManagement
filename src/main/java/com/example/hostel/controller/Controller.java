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


    @PostMapping("student/add")
    private String add(@RequestBody StudentInfo studentInfo) throws Exception{
        return service.addStudents(studentInfo);
    }
    @GetMapping("/student")
    private List<StudentInfo> viewAll(){
        return service.displayAll();
    }
    @GetMapping("/studentInfo/{studentId}")
    public StudentInfo getStudents(@PathVariable int studentId){
        return service.getStudents(studentId);
    }

    @PutMapping("/student/{StudentId}")
    public StudentInfo updateStudent(@PathVariable int StudentId, @RequestBody StudentInfo student ) {
        return service.updateStudent(StudentId, student);
    }

    @DeleteMapping("/student/{StudentId}")
    public StudentInfo deleteStudent(@PathVariable  String StudentId) {
        return service.deleteStudent(Integer.parseInt(StudentId));
    }

}