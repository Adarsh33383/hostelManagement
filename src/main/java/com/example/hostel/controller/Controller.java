package com.example.hostel.controller;

import com.example.hostel.entity.StudentInfo;
import com.example.hostel.service.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api")
public class Controller {

    @Autowired
    public ServiceImpl service;

    Logger logger = LoggerFactory.getLogger(Controller.class);
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("student/add")
    private String add(@RequestBody StudentInfo studentInfo) throws Exception {
        logger.info("Adding student details");
        return service.addStudents(studentInfo);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/students")
    private List<StudentInfo> viewAll() {
        logger.info("displaying all students");
        return service.displayAll();
    }
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/student/studentId/{studentId}")
    private StudentInfo getStudentById(@PathVariable int studentId) {//todo
        logger.info("fetching student data by Id");
        return service.getStudentById(studentId);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/student/roomNo/{roomNo}")
    private List<StudentInfo> getStudentByRoomNo(@PathVariable int roomNo) {
        logger.info("fetching student data by RoomNo");
        return service.getStudentByRoomNo(roomNo);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/student/studentId/{StudentId}")
    private StudentInfo updateStudent(@PathVariable int StudentId, @RequestBody StudentInfo student) {
        logger.info("Updating student data");
        return service.updateStudent(StudentId, student);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/student/studentId/{StudentId}")
    private String deleteStudent(@PathVariable String StudentId) {
        logger.info("Deleting student data");
        return service.deleteStudent(Integer.parseInt(StudentId));
    }

}