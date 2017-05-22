package com.org.projector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ProjectorApp{
    
	public static void main(String[] args) {
        SpringApplication.run(ProjectorApp.class, args);
        System.out.println("Spring Boot started: Projector Booking Server");
    }
}
