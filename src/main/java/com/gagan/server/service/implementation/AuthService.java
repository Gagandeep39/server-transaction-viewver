package com.gagan.server.service.implementation;

import com.gagan.server.domain.User;
import com.gagan.server.exceptions.InvalidCredentialException;
import com.gagan.server.model.JwtRequest;
import com.gagan.server.model.JwtResponse;
import com.gagan.server.repos.UserRepository;
import com.gagan.server.security.JwtProvider;
import com.gagan.server.service.IAuthService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtProvider jwtProvider;


	@Override
	public JwtResponse login(JwtRequest loginRequest) {
    User user = findUserByCredentials(loginRequest.getUserId(), loginRequest.getPassword());
    return JwtResponse.builder()
      .userId(user.getUserid())
      .token(jwtProvider.generateTokenWithUsername(user.getUserid().toString()))
      .build();
	}

	@Override
	public boolean checkIfUsernameExists(String username) {
		return false;
	}

	@Transactional(readOnly = true)
  public User findUserByCredentials(Integer username, String password) {
    User user = userRepository.findById(username)
        .orElseThrow(() -> new InvalidCredentialException("userid", "User " + username + " doesn't exist"));
    if (!passwordEncoder.matches(password, user.getPassword())) throw new InvalidCredentialException("password", "Invalid Password");
    return user;
  }
  
}
