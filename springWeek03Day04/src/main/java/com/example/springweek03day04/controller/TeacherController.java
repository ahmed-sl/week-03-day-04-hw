package com.example.springweek03day04.controller;

import com.example.springweek03day04.DTO.API;
import com.example.springweek03day04.DTO.ClassroomDTO;
import com.example.springweek03day04.model.Classroom;
import com.example.springweek03day04.model.Student;
import com.example.springweek03day04.model.Teacher;
import com.example.springweek03day04.service.ClassroomService;
import com.example.springweek03day04.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.apache.naming.factory.LookupFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers(){
        logger.info("Get teacher");
        return ResponseEntity.status(201).body(teacherService.getTeachers());
    }

    @PostMapping
    public ResponseEntity<API> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        logger.info("Add teacher");
        return ResponseEntity.status(200).body(new API("Teacher add !",200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherByID (@PathVariable Integer id){
        logger.info("Get teacher by ID");
        return ResponseEntity.status(200).body(teacherService.getTeacherByID(id));
    }

    @PostMapping("/classroom")
    public ResponseEntity<API> addClassroomToTeacher(@RequestBody ClassroomDTO classroomDTO){
        logger.info("Add classroom to  teacher");
        teacherService.addClassroomToTeacher(classroomDTO);
        return ResponseEntity.status(200).body(new API("add classroom to teacher successfully",200));
    }
}


