package com.example.ce3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ce3.model.Student;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class StudentController {
    @GetMapping("/student")
    public Student getInfo() {
        return new Student(1,"Mohana Prasad", "This is a sample description");
    }
    
    
}
