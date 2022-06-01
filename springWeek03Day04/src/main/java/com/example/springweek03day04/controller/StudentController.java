package com.example.springweek03day04.controller;

import com.example.springweek03day04.DTO.API;
import com.example.springweek03day04.model.Student;
import com.example.springweek03day04.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        logger.info("Get student");
        return ResponseEntity.status(201).body(studentService.getStudents());

    }

    @PostMapping
    public ResponseEntity<API> addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        logger.info("Add student");
        return ResponseEntity.status(200).body(new API("User add !",200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentByID (@PathVariable Integer id){
        logger.info("Get student by ID");
        return ResponseEntity.status(200).body(studentService.getStudentByID(id));
    }

    @PostMapping("/{studentID}/{classroomID}")
    public ResponseEntity<API> addClassroomToStudent(@PathVariable Integer studentID, @PathVariable Integer classroomID){
        logger.info("Add classroom to student");
        studentService.addClassroomToStudent(studentID,classroomID);
        return ResponseEntity.status(200).body(new API("add classroom to student successfully",200));

    }
}
