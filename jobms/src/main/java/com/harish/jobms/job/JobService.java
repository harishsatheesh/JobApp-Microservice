package com.harish.jobms.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);
    boolean deleteJobById(Long id);
    Job getJobById(Long id);
    boolean updateJobById(Long id, Job job);

}
