package com.example.interviewkit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<USer,String> {
}
