package com.example.springweek03day04.repository;

import com.example.springweek03day04.model.Classroom;
import com.example.springweek03day04.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
}
