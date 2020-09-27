package com.paynet.wallet.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;

@Entity
@Data
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
	
	@PrePersist
	protected void onCreate() {
	   createdAt = new Date();
	   isActive = true;
	   wallet = 1000;
	}
	
}
