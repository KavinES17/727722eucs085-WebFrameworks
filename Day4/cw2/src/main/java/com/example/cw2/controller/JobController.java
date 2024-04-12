package com.example.cw2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cw2.model.Job;
import com.example.cw2.service.JobService;

@RestController
@RequestMapping("/api")

public class JobController{
    @Autowired
    private JobService jobService;
   @PostMapping("/job")
    public ResponseEntity<Job> createMedicine(@RequestBody Job job) {

        Job createdjob = jobService.createJob(job);
        if(createdjob != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdjob);
        else    
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/job")

    public List<Job> getAllMedicines() {
        List<Job> jobs = jobService.getAllJobs();
        return jobs;
    }
    @GetMapping("/job/{jobId}")
    public Job getJobById(@PathVariable("jobId") int jobId) {
        Job job = jobService.getJobById(jobId);
        return job;
    }

}

