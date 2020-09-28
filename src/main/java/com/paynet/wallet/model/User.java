package com.paynet.wallet.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude = {"transactions"})
@ToString(exclude = {"transactions"})
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private long phoneNumber;
	private String password;
	private long wallet;
	private Date createdAt;
	private boolean isActive;
	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.LAZY, mappedBy = "user")
    private Set<Transactions> transactions;
	
	@PrePersist
	protected void onCreate() {
	   createdAt = new Date();
	   isActive = true;
	   wallet = 1000;
	}
	
}
