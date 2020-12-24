package com.gagan.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;


@Getter
@Setter
public class UserDTO {

    private Integer userId;

    @Size(max = 50)
    private String password;

}
