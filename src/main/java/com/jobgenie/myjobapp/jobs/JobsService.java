package com.jobgenie.myjobapp.jobs;

import java.util.List;

public interface JobsService {
    public List<Jobs> getAllJobs();
    public void createJob(Jobs job);
    public Jobs findJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Jobs job);
}
