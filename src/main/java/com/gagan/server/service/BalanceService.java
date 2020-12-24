package com.gagan.server.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.gagan.server.config.CustomNotFoundException;
import com.gagan.server.domain.Balance;
import com.gagan.server.model.BalanceDTO;
import com.gagan.server.repos.BalanceRepository;


@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;

    public BalanceService(final BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public List<BalanceDTO> findAll() {
        return balanceRepository.findAll()
                .stream()
                .map(balance -> mapToDTO(balance, new BalanceDTO()))
                .collect(Collectors.toList());
    }

    public BalanceDTO get(final Integer id) {
        return balanceRepository.findById(id)
                .map(balance -> mapToDTO(balance, new BalanceDTO()))
                .orElseThrow(CustomNotFoundException::new);
    }

    public Integer create(final BalanceDTO balanceDTO) {
        final Balance balance = new Balance();
        mapToEntity(balanceDTO, balance);
        return balanceRepository.save(balance).getId();
    }

    public void update(final Integer id, final BalanceDTO balanceDTO) {
        final Balance balance = balanceRepository.findById(id)
                .orElseThrow(CustomNotFoundException::new);
        mapToEntity(balanceDTO, balance);
        balanceRepository.save(balance);
    }

    public void delete(final Integer id) {
        balanceRepository.deleteById(id);
    }

    private BalanceDTO mapToDTO(final Balance balance, final BalanceDTO balanceDTO) {
        balanceDTO.setId(balance.getId());
        balanceDTO.setBalance(balance.getBalance());
        return balanceDTO;
    }

    private Balance mapToEntity(final BalanceDTO balanceDTO, final Balance balance) {
        balance.setBalance(balanceDTO.getBalance());
        return balance;
    }

}
