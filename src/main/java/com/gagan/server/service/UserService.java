package com.gagan.server.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.gagan.server.config.CustomNotFoundException;
import com.gagan.server.domain.User;
import com.gagan.server.model.UserDTO;
import com.gagan.server.repos.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> mapToDTO(user, new UserDTO()))
                .collect(Collectors.toList());
    }

    public UserDTO get(final Integer userid) {
        return userRepository.findById(userid)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(CustomNotFoundException::new);
    }

    public Integer create(final UserDTO userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getUserid();
    }

    public void update(final Integer userid, final UserDTO userDTO) {
        final User user = userRepository.findById(userid)
                .orElseThrow(CustomNotFoundException::new);
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Integer userid) {
        userRepository.deleteById(userid);
    }

    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
        userDTO.setUserid(user.getUserid());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO, final User user) {
        user.setPassword(userDTO.getPassword());
        return user;
    }

}
