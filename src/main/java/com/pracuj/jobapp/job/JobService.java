package com.pracuj.jobapp.job;

import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    List<Job> findAll();
    Job findById(Long id);
    void addJob(Job job);
    void deleteJob(Long id);
    void updateJob(Long id, Job job);

}
