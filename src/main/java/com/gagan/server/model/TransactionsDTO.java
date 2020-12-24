package com.gagan.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class TransactionsDTO {

    private Integer id;

    @NotNull
    private Integer sender;

    @NotNull
    private Integer reciever;

    @NotNull
    private Double amount;

}
