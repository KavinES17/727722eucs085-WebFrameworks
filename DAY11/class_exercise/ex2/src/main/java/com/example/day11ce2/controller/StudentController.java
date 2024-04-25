package com.example.day11ce2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day11ce2.model.Student;
import com.example.day11ce2.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable Long id)
    {
        return studentService.getStudent(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student)
    {
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/student/{id}")
    public Boolean deleteStudent(@PathVariable Long id)
    {
        return studentService.deleteStudent(id);
    }
}
