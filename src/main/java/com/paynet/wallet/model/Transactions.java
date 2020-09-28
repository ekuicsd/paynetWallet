package com.paynet.wallet.model;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.paynet.wallet.util.TransactionType;

import lombok.Data;

@Entity
@Data
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	private long amount;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	private Date dateOfTransaction;
	private long balance;
	
	@PrePersist
	protected void onCreate() {
		dateOfTransaction = new Date();
	}
}
