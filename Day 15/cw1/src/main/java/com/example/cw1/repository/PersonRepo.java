package com.example.cw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cw1.model.Person;

public interface PersonRepo extends JpaRepository<Person, String>{
}

    

