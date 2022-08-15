package com.example.interviewkit.controller;

import com.example.interviewkit.PpdtRoom;
import com.example.interviewkit.PpdtRoomDto;
import com.example.interviewkit.PpdtRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Controller
public class PpdtController {

    @Autowired
    PpdtRoomsRepository ppdtRoomsRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping(path = "/getPpdtRooms")
    public ResponseEntity<List<PpdtRoom>> getPpDtRooms(){

       return new ResponseEntity<>(ppdtRoomsRepository.findAll(), HttpStatus.OK);

    }

    @PostMapping(path = "/createPpdtRoom")
    public ResponseEntity<PpdtRoom> createPpdtRoom(PpdtRoomDto ppdtRoomDto) throws IOException {

        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(ppdtRoomDto.getTitle()));
        if(!mongoTemplate.find(query,PpdtRoom.class).isEmpty()){
              return new ResponseEntity<>(null,HttpStatus.CONFLICT);
        }
        Path path = Paths.get(System.getProperty("user.dir") + "/src/main/upload/static/images",
                ppdtRoomDto.getImageName().concat(".").concat("jpg"));

        Files.write(path, ppdtRoomDto.getMultipartFile().getBytes());
        PpdtRoom ppdtRoom = new PpdtRoom();
        ppdtRoom.setDate(new Date());
        ppdtRoom.setTitle(ppdtRoomDto.getTitle());
        ppdtRoom.setImageName(ppdtRoomDto.getImageName());
        ppdtRoom.setIsOpen(true);

        return new ResponseEntity<>(ppdtRoomsRepository.save(ppdtRoom),HttpStatus.OK);
    }


}