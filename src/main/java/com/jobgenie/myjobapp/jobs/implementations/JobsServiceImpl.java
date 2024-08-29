package com.jobgenie.myjobapp.jobs.implementations;

import com.jobgenie.myjobapp.jobs.Jobs;
import com.jobgenie.myjobapp.jobs.JobsService;
import com.jobgenie.myjobapp.jobs.repositories.JobRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobsServiceImpl implements JobsService {
//    List<Jobs> jobs = new ArrayList<>();
    JobRepo jobRepository;

    public JobsServiceImpl(JobRepo jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long newId = 0L;



    @Override
    public List<Jobs> getAllJobs() {

        return jobRepository.findAll();
    }

    @Override
    public void createJob(Jobs job) {
//        job.setId(++newId);
        jobRepository.save(job);

    }

    @Override
    public boolean updateJob(Long id, Jobs updatedJob) {
        Optional<Jobs> jobOpt =  jobRepository.findById(id);

            if(jobOpt.isPresent()){
                Jobs job = jobOpt.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setOrganisation(updatedJob.getOrganisation());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }

        return false;
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            if(jobRepository.existsById(id)){
       jobRepository.deleteById(id);
        return true;}
        return false;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public Jobs findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
}
