package com.gagan.server.service;

import com.gagan.server.model.BalanceDTO;

public interface IBalanceService {

  BalanceDTO fetchBalanceById();
  boolean hasBalance(Double balance);
  void updateBalance(double d);
  void updateBalance(Integer id, double d);
  
}
