package com.example.day6cy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day6cy.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
    
}
