package com.jobgenie.myjobapp.companies;

import java.util.List;

public interface CompanyService {
    public List<Companies> getAllCompanies();
    public void addCompany(Companies company);
    public Companies getCompanyById(Long id);
    public boolean deleteCompany(Long id);
    public boolean updateCompany(Long id, Companies company);

}
