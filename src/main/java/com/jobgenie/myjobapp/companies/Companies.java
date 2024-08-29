package com.jobgenie.myjobapp.companies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobgenie.myjobapp.jobs.Jobs;
import com.jobgenie.myjobapp.reviews.Reviews;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Jobs> jobs;

    @OneToMany(mappedBy = "company")
    private List<Reviews> reviews;

    public Companies() {
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Jobs> getJobs() {
        return jobs;
    }

    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }
}
