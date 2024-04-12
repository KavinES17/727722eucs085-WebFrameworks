package com.example.cw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.cw2.model.Job;
import com.example.cw2.repository.JobRepo;

@Service
public class JobService {
    @Autowired
    private JobRepo jobrepo;
    public Job createJob(Job job) {
        return jobrepo.save(job);
    }
    public List<Job> getAllJobs() {
        return (List<Job>) jobrepo.findAll();
    }
    public Job getJobById(int jobId) {
        return jobrepo.findById(jobId).orElse(null);
    }
}

