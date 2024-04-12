package com.example.cw4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cw4.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
    
}