package com.example.interviewkit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("quizQuestion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizQuestionModel {

    @Id
    private String questionId;
    private String question;
    private List<String> options;

}
