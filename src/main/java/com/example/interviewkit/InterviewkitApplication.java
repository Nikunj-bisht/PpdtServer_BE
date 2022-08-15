package com.example.interviewkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication()
public class InterviewkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewkitApplication.class, args);
	}



}
