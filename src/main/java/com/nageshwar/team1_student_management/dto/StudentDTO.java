package com.nageshwar.team1_student_management.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private Long studentId;

    private String studentName;

    private String email;

    private String course;

    private String phone;

    private String address;
}
