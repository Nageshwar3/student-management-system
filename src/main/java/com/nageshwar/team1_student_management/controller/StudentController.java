package com.nageshwar.team1_student_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nageshwar.team1_student_management.dto.StudentDTO;
import com.nageshwar.team1_student_management.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Add Student
    @PostMapping
    public StudentDTO addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    // Get All Students
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student By Id
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Search Student By Name
    @GetMapping("/search")
    public List<StudentDTO> searchStudents(
            @RequestParam String studentName) {
        return studentService.searchStudents(studentName);
    }

    // Sort Students
    @GetMapping("/sort")
    public List<StudentDTO> sortStudents(
            @RequestParam String field) {
        return studentService.sortStudents(field);
    }

    // Update Student
    @PutMapping("/{id}")
    public StudentDTO updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDTO studentDTO) {

        return studentService.updateStudent(id, studentDTO);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
}