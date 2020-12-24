package com.gagan.server.service.implementation;

import java.util.List;

import com.gagan.server.model.TransactionsDTO;
import com.gagan.server.service.ITransactionsService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransactionService implements ITransactionsService {@Override
	public List<TransactionsDTO> fetchAllTransaction(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionsDTO createTransaction(TransactionsDTO transaction) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
