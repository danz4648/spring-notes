package com.danz.springnotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danz.springnotes.request.RegisterRequest;
import com.danz.springnotes.response.RegisterResponse;
import com.danz.springnotes.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        response.setMessage(userService.saveUser(request));
        return ResponseEntity.ok(response);
    }
}
