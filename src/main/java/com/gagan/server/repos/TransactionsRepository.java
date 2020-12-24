package com.gagan.server.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.gagan.server.domain.Transactions;


public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    // add custom queries here
    List<Transactions> findBySender(Integer sender);
}
