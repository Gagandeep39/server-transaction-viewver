package com.gagan.server.service.implementation;

import com.gagan.server.service.IUserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Override
	public Integer fetchIdFromJwt() {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (!(authentication instanceof AnonymousAuthenticationToken)) {
        String currentUserName = authentication.getName();
        return Integer.parseInt(currentUserName);
      }
      else throw new RuntimeException("Error Validating TOken in Balance Service");
	}
  
}
