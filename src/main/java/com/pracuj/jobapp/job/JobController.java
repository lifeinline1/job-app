package com.pracuj.jobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id){
        if(jobService.findById(id) != null){
            return new ResponseEntity<>(jobService.findById(id), HttpStatus.OK);
        }else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>("Job added", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteJob(@PathVariable Long id){
        jobService.deleteJob(id);
        return new ResponseEntity<>("Job deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        if(jobService.findById(id) != null){
            jobService.updateJob(id, job);
            return new ResponseEntity<>("Job updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }

}
