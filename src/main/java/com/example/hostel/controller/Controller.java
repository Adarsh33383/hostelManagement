package com.example.hostel.controller;

import com.example.hostel.entity.StudentInfo;
import com.example.hostel.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    public ServiceImpl service;
    @GetMapping("/Student")
    private List<StudentInfo> getStudents(){
        return this.service.getStudents();
    }
    @PostMapping("/studentinfo/{studentId}")
    public StudentInfo getStudents(@PathVariable int studentId){
        return this.service.getStudents(studentId);
    }
}