package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.Employee;
import com.example.springapp.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/api/employee")
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee)
    {
        if(employeeService.saveEmployee(employee)==true)
        {
            return new ResponseEntity<>(employee,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/employee/bysalary")
    public ResponseEntity<List<Employee>> getEmployeeAll(@RequestParam int salary)
    {
        List<Employee> a=employeeService.getSalary(salary);
        if(a!=null)
        {
            return new ResponseEntity<List<Employee>>(a,HttpStatus.OK);
        }
        return new ResponseEntity<>(a,HttpStatus.NOT_FOUND);
        
    }
    
    @PutMapping("/api/employee")
    public ResponseEntity<Employee> putEmployeeSalary(@RequestParam int employeeId,@RequestParam int salary)
    {
        
        Employee e=employeeService.putEmployee(employeeId, salary);
        if(e!=null && e.getEmployeeId()==employeeId)
        {
            return new ResponseEntity<>(e,HttpStatus.OK);
        }
        return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);

        

    }
    @DeleteMapping("/api/employee")
    public ResponseEntity<String> deleteEmployeeSalary(@RequestParam int employeeId)
    {
        
        Employee c=employeeService.deleteEmployee(employeeId);
        if(c==null)
        {
            return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
