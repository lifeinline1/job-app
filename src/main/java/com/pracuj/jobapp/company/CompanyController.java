package com.pracuj.jobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping()
    public ResponseEntity<List<Company>> getCompany() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return new ResponseEntity<>(companyService.getCompanyById(company.getId()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        if(companyService.getCompanyById(id) != null){
            return new ResponseEntity<>(companyService.updateCompany(id, company), HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        if(companyService.getCompanyById(id) != null){
            return new ResponseEntity<>(companyService.deleteCompany(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not Found" ,HttpStatus.NOT_FOUND);
    }



}
