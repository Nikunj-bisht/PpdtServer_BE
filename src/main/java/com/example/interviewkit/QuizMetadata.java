package com.example.interviewkit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

 enum Status{
    passed,
    failed
}

@Document("QuizMetadata")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizMetadata {

    @Id
    private String Id;
    @DBRef
    USer uSer;
    @DBRef
    Quiz quiz;
    private Status status;



}
