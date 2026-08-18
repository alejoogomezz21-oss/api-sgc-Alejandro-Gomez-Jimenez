package com.cesde.coursemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.cesde.coursemanagement.domain.models")
public class CoursemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursemanagementApplication.class, args);
    }
}