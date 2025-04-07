package com.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.model.Run;
import com.spring.project.service.RunService;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    @Autowired
    private RunService runService;

    @GetMapping(value = "/")
    public List<Run> findaAll() {
        return runService.findaAllRuns();
    }

    @GetMapping(value = "/{id}")
    public Run findById(@PathVariable Long id) {
        return runService.findRunById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public void save(@RequestBody Run run) {
        runService.createRun(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}")
    public void update(@RequestBody Run run, @PathVariable Long id) {
        runService.updateRun(run, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        runService.deleteRun(id);
    }
}