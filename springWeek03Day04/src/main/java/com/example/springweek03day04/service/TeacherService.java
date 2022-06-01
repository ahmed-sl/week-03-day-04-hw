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
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ClassroomRepository classroomRepository;
    public List<Teacher> getTeachers() {
       return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher getTeacherByID(Integer id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()->new InvalidException("Invalid ID"));
        return teacher;
    }

    public void addClassroomToTeacher(ClassroomDTO classroomDTO) {
        Teacher teacher = teacherRepository.findById(classroomDTO.getTeacherID()).orElseThrow(()->new InvalidException("Invalid ID"));
        Classroom classroom = classroomRepository.findById(classroomDTO.getClassroomID()).orElseThrow(()->new InvalidException("Invalid ID"));
        classroom.setTeacher(teacher);
        classroomRepository.save(classroom);
        teacher.getClassrooms().add(classroom);
        teacherRepository.save(teacher);

    }


}
