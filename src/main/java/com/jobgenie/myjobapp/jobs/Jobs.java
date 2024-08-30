package com.jobgenie.myjobapp.jobs;

import com.jobgenie.myjobapp.companies.Companies;
import jakarta.persistence.*;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private String maxSalary;
    private String minSalary;
    @ManyToOne
    private Companies company;

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public Jobs(Long id, String title, String description, String location, String maxSalary, String minSalary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }
    public Jobs(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }
}
