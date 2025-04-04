package com.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.project.model.Run;

public interface RunRepository extends JpaRepository<Run, Long> {

}
