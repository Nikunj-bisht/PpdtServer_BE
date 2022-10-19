package com.example.interviewkit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizQuestionsRepository extends MongoRepository<QuizQuestionModel,String> {
}
