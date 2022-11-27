package com.example.hostel.controller;

import com.example.hostel.entity.StudentInfo;
import com.example.hostel.service.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api")
public class Controller {

    @Autowired
    public ServiceImpl service;

    Logger logger =LoggerFactory.getLogger(Controller.class);
    @PostMapping("student/add")
    private String add(@RequestBody StudentInfo studentInfo) throws Exception{
        return service.addStudents(studentInfo);
    }
    @GetMapping("/student")
    private List<StudentInfo> viewAll(){
        logger.info("[viewAll] info message");
        logger.warn("[viewAll] warn message");
        logger.error("[viewAll] error message");
        logger.trace("[viewAll] trace message");
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