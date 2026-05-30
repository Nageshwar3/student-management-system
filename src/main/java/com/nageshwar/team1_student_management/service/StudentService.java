
package com.nageshwar.team1_student_management.service;

import java.util.List;
import com.nageshwar.team1_student_management.dto.StudentDTO;

public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO updateStudent(Long id, StudentDTO studentDTO);

    void deleteStudent(Long id);
}