package com.gagan.server.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
public class User {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    private Integer userid;

    @Column(length = 50)
    private String password;


}
