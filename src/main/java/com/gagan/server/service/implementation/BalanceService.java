package com.gagan.server.service.implementation;

import com.gagan.server.config.CustomNotFoundException;
import com.gagan.server.domain.Balance;
import com.gagan.server.model.BalanceDTO;
import com.gagan.server.repos.BalanceRepository;
import com.gagan.server.service.IBalanceService;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BalanceService implements IBalanceService {

  private final BalanceRepository balanceRepository;

	@Override
	public BalanceDTO fetchBalanceById() {
		return balanceRepository.findById(fetchIdFromJwt())
    .map(balance -> mapToDTO(balance, new BalanceDTO()))
    .orElseThrow(CustomNotFoundException::new);
	}

	@Override
	public BalanceDTO updateBalance(BalanceDTO balance) {
		return null;
  }
  
  Integer fetchIdFromJwt() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      return Integer.parseInt(currentUserName);
    }
    else throw new RuntimeException("Error Validating TOken in Balance Service");
  }

  private BalanceDTO mapToDTO(final Balance balance, final BalanceDTO balanceDTO) {
    balanceDTO.setId(balance.getId());
    balanceDTO.setBalance(balance.getBalance());
    return balanceDTO;
  }

}
