package com.gagan.server.service;

import com.gagan.server.model.BalanceDTO;

public interface IBalanceService {

  BalanceDTO fetchBalanceById();
  BalanceDTO updateBalance(BalanceDTO balance);
  
}
