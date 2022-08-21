package com.example.interviewkit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinRoomResponse {

    private String status;
    private String message;

}
