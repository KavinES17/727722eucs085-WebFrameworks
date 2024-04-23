package com.example.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.*;
@Entity
public class Employee {
    @Id
    private int employeeId;
    private String employeeName;
    private String employeeEmail;
    private Date joinDate;
    private int salary;
    public Employee() {
    }
    public Employee(int employeeId, String employeeName, String employeeEmail, Date joinDate, int salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.joinDate = joinDate;
        this.salary = salary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeEmail() {
        return employeeEmail;
    }
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
