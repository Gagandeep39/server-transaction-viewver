package com.gagan.server.service;

import com.gagan.server.model.JwtRequest;
import com.gagan.server.model.JwtResponse;

public interface IAuthService {

  JwtResponse login(JwtRequest loginRequest);

  boolean checkIfUsernameExists(String username);
  
}
