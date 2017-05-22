package com.org.projector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectorApp {
	public static void main(String[] args) {
        SpringApplication.run(ProjectorApp.class, args);
        System.out.println("Spring Boot started: Projector Booking Server");
    }
}
