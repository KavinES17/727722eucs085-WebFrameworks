package com.example.day11ce2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day11ce2.model.Student;
import com.example.day11ce2.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public Student addStudent(Student student)
    {
        return studentRepo.save(student);
    }

    public List<Student> getStudents()
    {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudent(Long id)
    {
        return studentRepo.findById(id);
    }

    public Student updateStudent(Long id,Student student)
    {
        Student avail = studentRepo.findById(id).orElse(null);
        if(avail!=null)
        {
            avail.setName(student.getName());
            avail.setStudentIDCard(student.getStudentIDCard());
            return studentRepo.save(avail);
        }
        else
        return null;
    }

    public Boolean deleteStudent(Long id)
    {
        studentRepo.deleteById(id);
        return true;
    }
}
