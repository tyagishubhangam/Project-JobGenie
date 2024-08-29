package com.jobgenie.myjobapp.jobs.repositories;

import com.jobgenie.myjobapp.jobs.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Jobs, Long> {
}
