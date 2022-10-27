package com.example.interviewkit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "appuser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class USer {
    @Id
    private String id;
    private String name;
    private String password;
    private String fcmToken;
    @DBRef
    List<PpdtRoom> roomList;
    @DBRef
    List<QuizMetadata> quizMetadata;
    @DBRef
    List<Quiz> quizes;
}
