package com.example.cw4.service;

import com.example.cw4.model.Company;
import com.example.cw4.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(int id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }
}