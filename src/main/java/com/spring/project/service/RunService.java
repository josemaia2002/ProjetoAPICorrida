package com.spring.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.model.Run;
import com.spring.project.model.RunNotFoundException;
import com.spring.project.repository.RunRepository;

@Service
public class RunService {
    
    @Autowired
    private RunRepository runRepository;

    public List<Run> findaAllRuns() {
        return runRepository.findAll();
    }

    public Run findRunById(Long id) {
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }

    public void createRun(Run run) {
        runRepository.save(run);
    }

    public void updateRun(Run run, Long id) {
        Run updatedRun = findRunById(id);

        updatedRun.setTitle(run.getTitle());
        updatedRun.setStartedOn(run.getStartedOn());
        updatedRun.setCompletedOn(run.getCompletedOn());
        updatedRun.setMiles(run.getMiles());
        updatedRun.setLocation(run.getLocation());

        runRepository.save(updatedRun);
    }

    public void deleteRun(Long id) {
        Run run = findRunById(id);

        runRepository.delete(run);
    }
}