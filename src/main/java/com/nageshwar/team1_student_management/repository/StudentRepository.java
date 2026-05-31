package com.nageshwar.team1_student_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nageshwar.team1_student_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByStudentNameContainingIgnoreCase(String studentName);

}
