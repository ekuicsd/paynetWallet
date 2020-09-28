package com.paynet.wallet.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paynet.wallet.model.Transactions;
import com.paynet.wallet.model.User;
import com.paynet.wallet.repository.TransactionRepository;
import com.paynet.wallet.repository.UserRepository;
import com.paynet.wallet.util.TransactionType;

@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final TransactionRepository transactionRepository;
	
	public UserService(UserRepository userRepository, TransactionRepository transactionRepository) {
		this.userRepository = userRepository;
		this.transactionRepository = transactionRepository;
	}
	
	public String checkAddMoneyDetails(String cardNumber,String name,int month,int year,String cvv,long amount) {
		Date now = new Date();
		if(cardNumber.length() != 16) {
			return "Card number is not correct";
		} else if(month < 1 || month >12) {
			return "Month is not correct";
		} else if(year <= now.getYear() || String.valueOf(year).length() != 4) {
			return "Your card has been expired!";
		} else if(cvv.length() !=3) {
			return "Incorrect CVV";
		} else if(amount <= 0) {
			return "please enter amount";
		}
		return null;
	}
	
	public User addMoney(User user, TransactionType type, long amount) {
		Transactions transaction = new Transactions();
		transaction.setTransactionType(type);
		transaction.setAmount(amount);
		transaction.setBalance(user.getWallet() + amount);
		transaction.setUser(user);
		transactionRepository.save(transaction);
		return updateWallet(user, amount);
	}
	
	@Transactional
	public User updateWallet(User user, long amount) {
		user.setWallet(user.getWallet() + amount);
		return userRepository.save(user);
	}
	
	public ArrayList<Transactions> findAllTransactions(User user) {
		ArrayList<Transactions> list= new ArrayList<Transactions>();
		list = transactionRepository.findAllByUser(user);
		return list;
	}
 
}
