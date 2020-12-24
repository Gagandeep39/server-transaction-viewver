package com.gagan.server.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.gagan.server.model.UserDTO;
import com.gagan.server.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userid}")
    public UserDTO getUser(@PathVariable final Integer userid) {
        return userService.get(userid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createUser(@RequestBody @Valid final UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping("/{userid}")
    public void updateUser(@PathVariable final Integer userid, @RequestBody @Valid final UserDTO userDTO) {
        userService.update(userid, userDTO);
    }

    @DeleteMapping("/{userid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable final Integer userid) {
        userService.delete(userid);
    }

}
