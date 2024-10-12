package com.harish.jobms.job;

import com.harish.jobms.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {

    List<JobWithCompanyDTO> findAll();
    void createJob(Job job);
    boolean deleteJobById(Long id);
    Job getJobById(Long id);
    boolean updateJobById(Long id, Job job);

}
