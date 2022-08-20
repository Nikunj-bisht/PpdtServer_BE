package com.example.interviewkit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PpdtRoomDto {

    private MultipartFile multipartFile;
    private String title;
    private Date date;

    private String imageName;

    private Boolean isOpen;



}
