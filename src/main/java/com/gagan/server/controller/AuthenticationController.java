package com.gagan.server.controller;

import com.gagan.server.model.JwtRequest;
import com.gagan.server.model.JwtResponse;
import com.gagan.server.service.implementation.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
public class AuthenticationController {
  
  private final AuthService authService;
  @PostMapping("/login")
  public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest loginRequest) {
    return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
  }

}
