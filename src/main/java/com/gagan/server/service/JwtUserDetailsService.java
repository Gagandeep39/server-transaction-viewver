package com.gagan.server.service;

import java.util.ArrayList;

import com.gagan.server.domain.User;
import com.gagan.server.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService  implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository
    .findById(Integer.parseInt(username))
    .orElseThrow(() -> new UsernameNotFoundException("User " + username + " doesn't exist"));
    return new org.springframework.security.core.userdetails.User(user.getUserid().toString(), user.getPassword(), new ArrayList<>());
	}
  
}
