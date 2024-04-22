package com.example.day5cw2.service;

import org.springframework.stereotype.Service;

import com.example.day5cw2.model.Employee;
import com.example.day5cw2.repository.EmployeeRepo;

@Service
public class EmployeeService {
    public EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public boolean saveEmployee(Employee employee)
    {
        try
        {
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,Employee employee)
    {
        if(this.getEmployeeById(id)==null)
        {
            return false;
        }
        try{
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployeeById(id) == null)
        {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }
    public Employee getEmployeeById(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
}
