package com.gagan.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.gagan.server.model.BalanceDTO;
import com.gagan.server.service.IBalanceService;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/balances", produces = MediaType.APPLICATION_JSON_VALUE)
public class BalanceController {

    private final IBalanceService balanceService;

    @GetMapping
    public BalanceDTO getBalance() {
        return balanceService.fetchBalanceById();
    }

}
