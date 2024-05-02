package com.example.cw1.repository;

import com.example.cw1.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepo extends JpaRepository<Payroll,Long>{
    
}
