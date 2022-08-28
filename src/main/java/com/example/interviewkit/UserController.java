package com.example.interviewkit;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserRepository userRepository;
    @PostMapping(path = "/user")
   public ResponseEntity saveUSer(@RequestParam(name = "name") String name,@RequestParam(name = "password") String password){
        USer uSer = new USer();
        uSer.setName(name);
        uSer.setPassword(password);
        mongoTemplate.save(uSer);

        return new ResponseEntity("OK", HttpStatus.OK);

    }
    @GetMapping(value = "/getRooms")
    public ResponseEntity<USer> getUser(@RequestParam(name = "id") String id){

        return new ResponseEntity<>(userRepository.findById(id).get(),HttpStatus.OK);


    }

}
