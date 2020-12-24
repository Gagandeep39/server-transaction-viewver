package com.gagan.server.service;

import java.util.List;

import com.gagan.server.model.TransactionsDTO;

public interface ITransactionsService {

  List<TransactionsDTO> fetchAllTransaction();
  TransactionsDTO createTransaction(TransactionsDTO transaction);

}
