package com.example.ce2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce2.model.Student;

@RestController
public class StudentController {
    @GetMapping("/students")
    public Student getInfo() {
        return new Student("Mohana Prasad", 19);
    }
}
