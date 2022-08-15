package com.example.interviewkit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("ppdts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PpdtRoom {

    @Id
    private String id;

    private String title;

    private Date date;

    private String imageName;

    private Boolean isOpen;



}
