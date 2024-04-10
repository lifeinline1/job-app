package com.pracuj.jobapp.company;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public String addCompany(Company company) {
        companyRepository.save(company);
        return "Company Deleted Successfully";
    }

    @Override
    public String updateCompany(Long id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company newCompany = companyOptional.get();
            newCompany.setName(company.getName());
            newCompany.setDescription(company.getDescription());
            newCompany.setJobs(company.getJobs());
            companyRepository.save(newCompany);
        }
        return "Company Updated Successfully";
    }


    @Override
    public String deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return "Company Deleted Successfully";
    }
}
