package com.example.day11ce2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day11ce2.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    
}
