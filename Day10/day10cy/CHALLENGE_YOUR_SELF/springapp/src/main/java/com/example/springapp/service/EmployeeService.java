package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    public boolean saveEmployee(Employee employee)
    {
        try{
            employeeRepo.save(employee);
            return true;
        }
        catch(Exception e)
        {
            
            return false;
        }
    }
    public List<Employee> getSalary(int salary)
    {
        return employeeRepo.findBySalary(salary);
    }
    
    public Employee putEmployee(int employeeId,int salary)
    {
        employeeRepo.findByEmployeeIdSalary(employeeId, salary);
        return employeeRepo.findById(employeeId).orElse(null);
    }
    
    public Employee deleteEmployee(int employeeId)
    {
        employeeRepo.deleteByEmployeeId(employeeId);
        return employeeRepo.findById(employeeId).orElse(null);
        
    }

}
