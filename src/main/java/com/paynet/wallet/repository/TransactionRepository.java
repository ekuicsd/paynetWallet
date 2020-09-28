package com.paynet.wallet.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paynet.wallet.model.Transactions;
import com.paynet.wallet.model.User;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Long> {

	ArrayList<Transactions> findAllByUser(User user);
	
	Transactions save(Transactions transcation);
	
}
