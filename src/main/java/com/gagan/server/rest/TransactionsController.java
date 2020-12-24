package com.gagan.server.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.gagan.server.model.TransactionsDTO;
import com.gagan.server.service.TransactionsService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(value = "/api/transactionss", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionsController {

    private final TransactionsService transactionsService;

    public TransactionsController(final TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping
    public List<TransactionsDTO> getAllTransactionss() {
        return transactionsService.findAll();
    }

    @GetMapping("/{id}")
    public TransactionsDTO getTransactions(@PathVariable final Integer id) {
        return transactionsService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createTransactions(@RequestBody @Valid final TransactionsDTO transactionsDTO) {
        return transactionsService.create(transactionsDTO);
    }

    @PutMapping("/{id}")
    public void updateTransactions(@PathVariable final Integer id, @RequestBody @Valid final TransactionsDTO transactionsDTO) {
        transactionsService.update(id, transactionsDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransactions(@PathVariable final Integer id) {
        transactionsService.delete(id);
    }

}
