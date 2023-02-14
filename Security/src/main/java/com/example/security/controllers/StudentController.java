package com.example.security.controllers;

import com.example.security.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private  static final List<Student> STUDENTS = new ArrayList<>(Arrays.asList(
            new Student(1,"James Maliu"),
            new Student(2,"Maria Jana"),
            new Student(3,"Anna Onno")
    ));

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Studet " + studentId + " does not exists"));
    }
}
