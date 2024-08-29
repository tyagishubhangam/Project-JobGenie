package com.jobgenie.myjobapp.companies.repositories;

import com.jobgenie.myjobapp.companies.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Companies, Long> {
}
