package com.example.interviewkit.controller;

import com.example.interviewkit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class QuizController {
@Autowired
    QuizRepository quizRepository;
@Autowired
UserRepository userRepository;
@Autowired
QuizRecordRepository quizRecordRepository;
@Autowired
QuizQuestionsRepository quizQuestionsRepository;
@PostMapping(value = "/quiz")
    public ResponseEntity addQuiz(){
  Quiz quiz =  new Quiz();
  quiz.setQuizName("sample");
     quizRepository.save(quiz);
    return new ResponseEntity("OK", HttpStatus.CREATED);
}

    @PostMapping(value = "/quizRecord")
    public ResponseEntity quizRecord(){
        Quiz quiz = quizRepository.findAll().get(0);
        USer uSer = userRepository.findById("631cdb110ec5f86abefb72fd").get();
        QuizMetadata quizMetadata = new QuizMetadata();

//      quizMetadata.setStatus(Status.passed);
        quizMetadata.setQuiz(quiz);
        quizRecordRepository.save(quizMetadata);
        uSer.setQuizMetadata(new ArrayList<>(Arrays.asList(quizMetadata)));
        userRepository.save(uSer);
        return new ResponseEntity("OK", HttpStatus.CREATED);
    }

    @PostMapping("/createQuiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDto quizDto){
       Quiz quiz = new Quiz();
       quiz.setQuizName(quizDto.getQuizName());
       List<QuizQuestionModel> quizQuestionModels = quizDto.getQuizQuestions().stream().map(quizQuestion ->{
           QuizQuestionModel quizQuestionModel = new QuizQuestionModel();
           quizQuestionModel.setQuestion(quizQuestion.getQuestion());
           quizQuestionModel.setOptions(quizQuestion.getOptions());
            return quizQuestionModel;
                }
                ).collect(Collectors.toList());
       quizQuestionsRepository.saveAll(quizQuestionModels);
       quiz.setQuizQuestionModels(quizQuestionModels);
       quiz = quizRepository.save(quiz);

        return new ResponseEntity(quiz,HttpStatus.CREATED);


    }




}
