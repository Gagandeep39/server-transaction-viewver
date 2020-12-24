package com.gagan.server.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gagan.server.domain.Transactions;


public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    // add custom queries here
}
