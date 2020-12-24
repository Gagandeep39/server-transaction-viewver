package com.gagan.server.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.gagan.server.model.BalanceDTO;
import com.gagan.server.service.BalanceService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(value = "/api/balances", produces = MediaType.APPLICATION_JSON_VALUE)
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(final BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping
    public List<BalanceDTO> getAllBalances() {
        return balanceService.findAll();
    }

    @GetMapping("/{id}")
    public BalanceDTO getBalance(@PathVariable final Integer id) {
        return balanceService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createBalance(@RequestBody @Valid final BalanceDTO balanceDTO) {
        return balanceService.create(balanceDTO);
    }

    @PutMapping("/{id}")
    public void updateBalance(@PathVariable final Integer id, @RequestBody @Valid final BalanceDTO balanceDTO) {
        balanceService.update(id, balanceDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBalance(@PathVariable final Integer id) {
        balanceService.delete(id);
    }

}
