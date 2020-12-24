package com.gagan.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.gagan.server.model.TransactionsDTO;
import com.gagan.server.service.ITransactionsService;

import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionsController {

    private final ITransactionsService transactionsService;

    @GetMapping
    public List<TransactionsDTO> getTransactions() {
        return transactionsService.fetchAllTransaction();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionsDTO createTransactions(@RequestBody @Valid final TransactionsDTO transaction) {
        return transactionsService.createTransaction(transaction);
    }

}
