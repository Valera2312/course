package com.example.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@EnableMongoRepositories(basePackages = "com.example.bookservice.repositories")
public class BookServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(BookServiceApp.class, args);
    }
}
