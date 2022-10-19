package com.example.interviewkit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz,Long> {
}
