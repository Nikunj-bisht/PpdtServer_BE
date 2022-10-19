package com.example.interviewkit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRecordRepository extends MongoRepository<QuizMetadata,Long> {
}
