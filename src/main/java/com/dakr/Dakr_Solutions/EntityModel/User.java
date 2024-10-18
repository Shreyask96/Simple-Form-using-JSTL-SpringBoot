package com.dakr.Dakr_Solutions.EntityModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;

    @NotBlank(message = "Goal is required")
    private String goal;

    @NotBlank(message = "Five-Year Roadmap is required")
    private String fiveYearRoadmap;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getFiveYearRoadmap() {
        return fiveYearRoadmap;
    }

    public void setFiveYearRoadmap(String fiveYearRoadmap) {
        this.fiveYearRoadmap = fiveYearRoadmap;
    }
}
