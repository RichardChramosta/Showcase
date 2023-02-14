package com.example.security.controllers;

import com.example.security.models.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManageController {

    private  static final List<Student> STUDENTS = new ArrayList<>(Arrays.asList(
            new Student(1,"James Maliu"),
            new Student(2,"Maria Jana"),
            new Student(3,"Anna Onno")
    ));
    // hasRole("ROLE_") hasAuthority('permission')     All   Any
@GetMapping
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        return STUDENTS;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudents(@RequestBody Student student){
        System.out.println(student);
    }
    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer studentId){
        System.out.println(studentId);
    }
    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')") /// replace antMatchers
    public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student){
        System.out.println(String.format("%s %s", studentId,student));
    }
}
