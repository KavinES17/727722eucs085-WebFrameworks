package com.example.cw1.service;

import com.example.cw1.model.Payroll;
import com.example.cw1.repository.PayrollRepo;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {
    private final PayrollRepo payrollRepo;

    public PayrollService(PayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public Payroll createPayroll(Payroll payroll) {
        return payrollRepo.save(payroll);
    }

    public Payroll getPayrollByEmployeeId(Long employeeId) {
        return payrollRepo.findById(employeeId).orElse(null);
    }
}
