package com.example.hostel;
import com.example.hostel.controller.Controller;
import com.example.hostel.entity.StudentInfo;
import com.example.hostel.exception.StudentIdAlreadyPresentException;
import com.example.hostel.exception.StudentNotFoundException;
import com.example.hostel.service.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class HostelApplicationTest {


    @Autowired
     ServiceImpl service;

    StudentInfo studentInfo;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    Controller controller;

   @BeforeEach
    public void setUp(){
       studentInfo =new StudentInfo();
       studentInfo.setStudentId(11);
       studentInfo.setStudentName("shweta");
       studentInfo.setRoomNo(101);
       studentInfo.setAddress("pune");
       studentInfo.setPhoneNumber(9675646504L);
   }

    @Test
    @DisplayName("Testing add method")
    void addStudent() {
     // service.addStudents(studentInfo);
         service.getStudent(studentInfo.getStudentId());
       assertThrows(StudentIdAlreadyPresentException.class,()->service.addStudents(studentInfo),"StudentId already present");
    }
    @Test
    @DisplayName("Testing get method")
    void getStudent() {
        // service.addStudents(studentInfo);
        studentInfo.setStudentId(11);
        service.getStudent(studentInfo.getStudentId());
        assertThrows(StudentIdAlreadyPresentException.class,()->service.addStudents(studentInfo),"StudentId already present");

    }
    @Test
    @DisplayName("Testing update method")
    void updateStudent() {
     service.addStudents(studentInfo);
      assertThrows(StudentIdAlreadyPresentException.class,()->service.addStudents(studentInfo)," Student Already present");
   }

    @Test
    @DisplayName("Testing delete method")
    void deleteStudent() {
        service.addStudents(studentInfo);
      service.deleteStudent(studentInfo.getStudentId());
        assertThrows(StudentNotFoundException.class,()->service.deleteStudent(studentInfo.getStudentId()),"Student not found");
    }

    @Test
    @DisplayName("post mapping ")
   void testControllerAddStudent() throws Exception {
        ObjectMapper mapper= new ObjectMapper();
       service.addStudents(studentInfo);
        this.mockMvc.perform(post("/student/add")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(mapper.writeValueAsString(studentInfo)))
                .andReturn();
   }
    @Test
    @DisplayName("get mapping")
    void testControllerGetStudent() throws Exception{
        ObjectMapper mapper= new ObjectMapper();
        this.mockMvc.perform(get("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(mapper.writeValueAsString(studentInfo)))
                .andReturn();

    }

   @Test
  @DisplayName("put mapping")
  void testControllerUpdateStudent() throws Exception{
      ObjectMapper mapper= new ObjectMapper();
    // service.addStudents(studentInfo);
      studentInfo.setStudentId(11);
      studentInfo.setStudentName("Mishu");
     service.updateStudent(studentInfo.getStudentId(),studentInfo);
      this.mockMvc.perform(put("/student/studentId")
                     .contentType(MediaType.APPLICATION_JSON)
                     .contentType(mapper.writeValueAsString(studentInfo)))
                     .andReturn();

  }

  @Test
    @DisplayName("Delete mapping")
  void testControllerDeleteStudent() throws Exception{
       ObjectMapper mapper = new ObjectMapper();
      //service.addStudent(studentInfo);
      service.deleteStudent(studentInfo.getStudentId());
      this.mockMvc.perform(delete("/student/studentId")
                      .contentType(MediaType.APPLICATION_JSON)
                      .contentType(mapper.writeValueAsString(studentInfo.getStudentId())))
                      .andReturn();
  }
}





