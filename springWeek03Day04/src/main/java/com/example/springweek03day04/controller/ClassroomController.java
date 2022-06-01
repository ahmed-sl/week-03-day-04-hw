package com.example.springweek03day04.controller;

import com.example.springweek03day04.DTO.API;
import com.example.springweek03day04.DTO.ClassroomDTO;
import com.example.springweek03day04.model.Classroom;
import com.example.springweek03day04.model.Student;
import com.example.springweek03day04.service.ClassroomService;
import com.example.springweek03day04.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/classroom")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;

    Logger logger = LoggerFactory.getLogger(ClassroomController.class);

    @GetMapping
    public ResponseEntity<List<Classroom>> getClassrooms(){
        logger.info("Get classroom");
        return ResponseEntity.status(201).body(classroomService.getClassrooms());
    }

    @PostMapping
    public ResponseEntity<API> addClassroom(@RequestBody @Valid Classroom classroom){
        classroomService.addClassroom(classroom);
        logger.info("Add classroom");
        return ResponseEntity.status(200).body(new API("Classroom add !",200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomByID (@PathVariable Integer id){
        logger.info("Get classroom by ID");
        return ResponseEntity.status(200).body(classroomService.getClassroomByID(id));
    }
}
