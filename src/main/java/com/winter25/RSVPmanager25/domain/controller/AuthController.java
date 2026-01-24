package com.winter25.RSVPmanager25.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/signup")
    public ResponseEntity<Object> signup() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("boo");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sorry");
    }
}