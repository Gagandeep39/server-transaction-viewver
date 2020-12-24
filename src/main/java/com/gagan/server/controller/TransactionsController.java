package com.gagan.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.gagan.server.model.TransactionsDTO;
import com.gagan.server.service.TransactionsService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionsController {

    private final TransactionsService transactionsService;

    @GetMapping("/{id}")
    public TransactionsDTO getTransactions(@PathVariable final Integer id) {
        return transactionsService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createTransactions(@RequestBody @Valid final TransactionsDTO transactionsDTO) {
        return transactionsService.create(transactionsDTO);
    }

}
