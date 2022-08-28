package com.example.interviewkit;

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

    @DBRef

    List<PpdtRoom> roomList;
}
