package com.nageshwar.team1_student_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nageshwar.team1_student_management.dto.StudentDTO;
import com.nageshwar.team1_student_management.entity.Student;
import com.nageshwar.team1_student_management.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {

        Student student = new Student();

        student.setStudentName(studentDTO.getStudentName());
        student.setEmail(studentDTO.getEmail());
        student.setCourse(studentDTO.getCourse());
        student.setPhone(studentDTO.getPhone());
        student.setAddress(studentDTO.getAddress());

        studentRepository.save(student);

        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students.stream().map(student -> {

            StudentDTO dto = new StudentDTO();

            dto.setStudentId(student.getStudentId());
            dto.setStudentName(student.getStudentName());
            dto.setEmail(student.getEmail());
            dto.setCourse(student.getCourse());
            dto.setPhone(student.getPhone());
            dto.setAddress(student.getAddress());

            return dto;

        }).toList();
    }

    @Override
    public StudentDTO getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        StudentDTO dto = new StudentDTO();

        dto.setStudentId(student.getStudentId());
        dto.setStudentName(student.getStudentName());
        dto.setEmail(student.getEmail());
        dto.setCourse(student.getCourse());
        dto.setPhone(student.getPhone());
        dto.setAddress(student.getAddress());

        return dto;
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setStudentName(studentDTO.getStudentName());
        student.setEmail(studentDTO.getEmail());
        student.setCourse(studentDTO.getCourse());
        student.setPhone(studentDTO.getPhone());
        student.setAddress(studentDTO.getAddress());

        studentRepository.save(student);

        return studentDTO;
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }
}