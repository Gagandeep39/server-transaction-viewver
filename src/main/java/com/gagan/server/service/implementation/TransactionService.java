package com.gagan.server.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.gagan.server.domain.Transactions;
import com.gagan.server.model.TransactionsDTO;
import com.gagan.server.repos.TransactionsRepository;
import com.gagan.server.service.IBalanceService;
import com.gagan.server.service.ITransactionsService;
import com.gagan.server.service.IUserService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransactionService implements ITransactionsService {
	
	private final IUserService userService;
	private final IBalanceService balanceService;
	private final TransactionsRepository transactionRepository;
	
	@Override
	public List<TransactionsDTO> fetchAllTransaction() {
		return transactionRepository
			.findBySender(userService.fetchIdFromJwt()).stream()
			.map(transaction -> mapToDTO(transaction, new TransactionsDTO()))
			.collect(Collectors.toList());
	}

	@Override
	public TransactionsDTO createTransaction(TransactionsDTO transaction) {
		if(!balanceService.hasBalance(transaction.getAmount()))
			throw new RuntimeException("Insufficient Balance");
		balanceService.updateBalance(-transaction.getAmount());
		balanceService.updateBalance(transaction.getReciever(), transaction.getAmount());
		final Transactions transactions = new Transactions();
		mapToEntity(transaction, transactions);
		return mapToDTO(transactionRepository.save(transactions), new TransactionsDTO());
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
