package com.example.springweek03day04.service;

import com.example.springweek03day04.DTO.ClassroomDTO;
import com.example.springweek03day04.exception.InvalidException;
import com.example.springweek03day04.model.Classroom;
import com.example.springweek03day04.model.Teacher;
import com.example.springweek03day04.repository.ClassroomRepository;
import com.example.springweek03day04.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }


    public void addClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public Classroom getClassroomByID(Integer id) {
        Classroom classroom = classroomRepository.findById(id).orElseThrow(()-> new InvalidException("Invalid ID"));
        return classroom;
    }


}
