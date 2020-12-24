package com.gagan.server.service;

import java.util.List;

import com.gagan.server.model.TransactionsDTO;

public interface ITransactionsService {

  List<TransactionsDTO> fetchAllTransaction(Integer id);
  TransactionsDTO createTransaction(TransactionsDTO transaction);

}
