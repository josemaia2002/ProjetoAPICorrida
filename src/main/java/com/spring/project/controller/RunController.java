package com.spring.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.model.Run;
import com.spring.project.model.RunNotFoundException;
import com.spring.project.repository.RunRepository;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    @Autowired
    private RunRepository runRepository;

    @GetMapping(value = "/")
    public List<Run> findaAll() {
        return runRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Run findById(@PathVariable Long id) {
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public void save(@RequestBody Run run) {
        runRepository.save(run);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new RunNotFoundException();
        }

        runRepository.delete(run.get());
    }

}
