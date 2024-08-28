package com.jobgenie.myjobapp.jobs.implementations;

import com.jobgenie.myjobapp.jobs.Jobs;
import com.jobgenie.myjobapp.jobs.JobsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class JobsServiceImpl implements JobsService {
    List<Jobs> jobs = new ArrayList<>();
    private Long newId = 0L;



    @Override
    public List<Jobs> getAllJobs() {
        return jobs;
    }

    @Override
    public void createJob(Jobs job) {
        job.setId(++newId);
        jobs.add(job);

    }

    @Override
    public boolean updateJob(Long id, Jobs updatedJob) {
        for(Jobs job : jobs){
            if(job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setOrganisation(updatedJob.getOrganisation());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Jobs> iterator = jobs.iterator();
        while(iterator.hasNext()) {
            Jobs job = iterator.next();
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public Jobs findJobById(Long id) {
        for(Jobs job : jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }
}
