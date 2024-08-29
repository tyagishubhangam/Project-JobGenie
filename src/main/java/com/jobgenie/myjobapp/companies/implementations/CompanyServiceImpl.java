package com.jobgenie.myjobapp.companies.implementations;

import com.jobgenie.myjobapp.companies.Companies;
import com.jobgenie.myjobapp.companies.CompanyService;
import com.jobgenie.myjobapp.companies.repositories.CompanyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    CompanyRepo companyRepo;


    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Companies> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public void addCompany(Companies company) {
        companyRepo.save(company);
    }

    @Override
    public Companies getCompanyById(Long id) {
       Optional<Companies> company = companyRepo.findById(id);
        return company.orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        try{
            if(companyRepo.existsById(id)){
            companyRepo.deleteById(id);
            return true;}return false;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateCompany(Long id, Companies updatedCompany) {
        Optional<Companies> companyOpt = companyRepo.findById(id);
        if (companyOpt.isPresent()) {
            Companies company = companyOpt.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepo.save(company);
            return true;
        }
        return false;

    }
}
