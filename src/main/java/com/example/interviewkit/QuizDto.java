package com.example.interviewkit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
   public static class QuizQuestions{

        private String question;
        private List<String> options;

    }

    private String quizName;
    private List<QuizQuestions> quizQuestions;
}
