package com.gagan.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.gagan.server.model.BalanceDTO;
import com.gagan.server.service.BalanceService;
import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/balances", produces = MediaType.APPLICATION_JSON_VALUE)
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping("/{id}")
    public BalanceDTO getBalance(@PathVariable final Integer id) {
        return balanceService.get(id);
    }

    @PutMapping("/{id}")
    public void updateBalance(@PathVariable final Integer id, @RequestBody @Valid final BalanceDTO balanceDTO) {
        balanceService.update(id, balanceDTO);
    }

}
