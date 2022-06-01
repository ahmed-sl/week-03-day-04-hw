package com.example.springweek03day04.service;

import com.example.springweek03day04.exception.InvalidException;
import com.example.springweek03day04.model.Classroom;
import com.example.springweek03day04.model.Student;
import com.example.springweek03day04.repository.ClassroomRepository;
import com.example.springweek03day04.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentByID(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new InvalidException("Invalid ID"));
        return student;
    }

    public void addClassroomToStudent(Integer studentID, Integer classroomID) {
        Student student = studentRepository.findById(studentID).orElseThrow(()-> new InvalidException("Invalid ID"));
        Classroom classroom = classroomRepository.findById(classroomID).orElseThrow(()-> new InvalidException("Invalid ID"));
        student.getClassrooms().add(classroom);
        classroom.getStudents().add(student);
        studentRepository.save(student);
    }
}
