package com.example.interviewkit;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserRepository userRepository;
    @PostMapping(path = "/user")
   public ResponseEntity<UserResponse> saveUSer(@RequestBody UserDto userDto){
        USer uSer = new USer();
        uSer.setName(userDto.getUserName());
        uSer.setPassword(userDto.getPassword());
        USer uSer1 = mongoTemplate.save(uSer);

        return new ResponseEntity(new UserResponse(uSer1.getName(),uSer1.getId()), HttpStatus.OK);

    }
    @GetMapping(value = "/getRooms")
    public ResponseEntity<USer> getUser(@RequestParam(name = "id") String id){

        return new ResponseEntity<>(userRepository.findById(id).get(),HttpStatus.OK);


    }

}
