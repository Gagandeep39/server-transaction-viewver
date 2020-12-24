package com.gagan.server.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.gagan.server.config.CustomNotFoundException;
import com.gagan.server.domain.Transactions;
import com.gagan.server.model.TransactionsDTO;
import com.gagan.server.repos.TransactionsRepository;


@Service
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;

    public TransactionsService(final TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public List<TransactionsDTO> findAll() {
        return transactionsRepository.findAll()
                .stream()
                .map(transactions -> mapToDTO(transactions, new TransactionsDTO()))
                .collect(Collectors.toList());
    }

    public TransactionsDTO get(final Integer id) {
        return transactionsRepository.findById(id)
                .map(transactions -> mapToDTO(transactions, new TransactionsDTO()))
                .orElseThrow(CustomNotFoundException::new);
    }

    public Integer create(final TransactionsDTO transactionsDTO) {
        final Transactions transactions = new Transactions();
        mapToEntity(transactionsDTO, transactions);
        return transactionsRepository.save(transactions).getId();
    }

    public void update(final Integer id, final TransactionsDTO transactionsDTO) {
        final Transactions transactions = transactionsRepository.findById(id)
                .orElseThrow(CustomNotFoundException::new);
        mapToEntity(transactionsDTO, transactions);
        transactionsRepository.save(transactions);
    }

    public void delete(final Integer id) {
        transactionsRepository.deleteById(id);
    }

    private TransactionsDTO mapToDTO(final Transactions transactions, final TransactionsDTO transactionsDTO) {
        transactionsDTO.setId(transactions.getId());
        transactionsDTO.setSender(transactions.getSender());
        transactionsDTO.setReciever(transactions.getReciever());
        transactionsDTO.setAmount(transactions.getAmount());
        return transactionsDTO;
    }

    private Transactions mapToEntity(final TransactionsDTO transactionsDTO, final Transactions transactions) {
        transactions.setSender(transactionsDTO.getSender());
        transactions.setReciever(transactionsDTO.getReciever());
        transactions.setAmount(transactionsDTO.getAmount());
        return transactions;
    }

}
