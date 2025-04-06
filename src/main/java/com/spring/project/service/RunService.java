package com.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.model.Run;
import com.spring.project.repository.RunRepository;

@Service
public class RunService {
    
    @Autowired
    private RunRepository runRepository;

}