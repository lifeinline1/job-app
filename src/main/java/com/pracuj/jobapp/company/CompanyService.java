package com.pracuj.jobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    String addCompany(Company company);
    String updateCompany(Long id, Company company);
    String deleteCompany(Long id);

}
