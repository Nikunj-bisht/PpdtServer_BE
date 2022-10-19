package com.example.interviewkit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    @Id
    private String quizId;
    private String quizName;
    @DBRef
    List<QuizQuestionModel> quizQuestionModels;


}
