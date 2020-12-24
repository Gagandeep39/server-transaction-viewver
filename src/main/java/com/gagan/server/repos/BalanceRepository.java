package com.gagan.server.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gagan.server.domain.Balance;


public interface BalanceRepository extends JpaRepository<Balance, Integer> {
    // add custom queries here
}
