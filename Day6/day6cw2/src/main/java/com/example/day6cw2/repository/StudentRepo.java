package com.example.day6cw2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day6cw2.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
    
}
