package com.example.cw2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cw2.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job,Integer> {
    
}

