package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Employee;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
    @Query("select a from Employee a where a.salary=?1")
    List<Employee> findBySalary(int salary);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Employee SET salary=?2 WHERE employee_id=?1", nativeQuery = true)
    void findByEmployeeIdSalary(int employeeId,int salary);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE from Employee where employee_id=?1", nativeQuery = true)
    void deleteByEmployeeId(int employeeId);
    
} 