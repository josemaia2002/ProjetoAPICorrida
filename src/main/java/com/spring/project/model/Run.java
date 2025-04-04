package com.spring.project.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "run", schema = "public")
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "started_on")
    private LocalDateTime startedOn;

    @Column(name = "completed_on")
    private LocalDateTime completedOn;

    @Column(name = "miles")
    private int miles;

    @Column(name = "location")
    private Location location;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }
    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }
    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public int getMiles() {
        return miles;
    }
    public void setMiles(int miles) {
        this.miles = miles;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
}