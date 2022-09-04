package com.example.interviewkit;


import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.MulticastMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotificationService {

    @Autowired
    FirebaseMessaging firebaseMessaging;

    public void sendNotifications(ArrayList<String> tokens,String message,String sender) throws FirebaseMessagingException {

        MulticastMessage multicastMessage = MulticastMessage.builder()
                .putData(sender,message)
                .addAllTokens(tokens)
                .build();

       BatchResponse batchResponse = firebaseMessaging.sendMulticast(multicastMessage);

System.out.println(batchResponse.getSuccessCount()+"succ");



    }
}
