package com.example.day5cw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day5cw3.model.Language;

public interface LanguageRepo extends JpaRepository<Language,Integer>{
    
}
