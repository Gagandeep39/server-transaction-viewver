package com.gagan.server.service.implementation;

import com.gagan.server.domain.Balance;
import com.gagan.server.exceptions.InvalidCredentialException;
import com.gagan.server.model.BalanceDTO;
import com.gagan.server.repos.BalanceRepository;
import com.gagan.server.service.IBalanceService;
import com.gagan.server.service.IUserService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class BalanceService implements IBalanceService {

  private final BalanceRepository balanceRepository;
  private final IUserService userService;

	@Override
	public BalanceDTO fetchBalanceById() {
		return balanceRepository.findById(userService.fetchIdFromJwt())
    .map(balance -> mapToDTO(balance, new BalanceDTO()))
    .orElseThrow(InvalidCredentialException::new);
	}

  private BalanceDTO mapToDTO(final Balance balance, final BalanceDTO balanceDTO) {
    balanceDTO.setId(balance.getId());
    balanceDTO.setBalance(balance.getBalance());
    return balanceDTO;
  }

@Override
  public boolean hasBalance(Double balance) {
    return balanceRepository
      .findById(userService.fetchIdFromJwt())
      .orElseThrow(() -> new InvalidCredentialException("userid", "Not Found User"))
      .getBalance() >= balance;
  }

  @Override
  public void updateBalance(double amount) {
    updateBalance(userService.fetchIdFromJwt(), amount);
  }
  @Override
  public void updateBalance(Integer id, double amount) {  
    final Balance balance = balanceRepository.findById(id)
      .orElseThrow(InvalidCredentialException::new);
      log.info(amount + "");
    balance.setBalance(balance.getBalance() + amount);
    balanceRepository.save(balance);
  }

}
