package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Student;
import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

    List<Student> findByMarksGreaterThan(int marks); 
    List<Student> findByMarksLessThan(int marks); 
}
