package com.winter25.RSVPmanager25.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @PostMapping("/getUserEvents")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("boo");
    }

    @PostMapping("/createEvent")
    public ResponseEntity<Object> create() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sorry");
    }

    @PostMapping("/editEvent")
    public ResponseEntity<Object> edit() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sorry");
    }

    @PostMapping("/deleteEvent")
    public ResponseEntity<Object> delete() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sorry");
    }
}