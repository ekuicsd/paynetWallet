package com.paynet.wallet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paynet.wallet.model.Transactions;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Long> {

}
