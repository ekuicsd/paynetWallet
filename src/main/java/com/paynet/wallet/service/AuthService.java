package com.paynet.wallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paynet.wallet.model.User;
import com.paynet.wallet.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private final UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public boolean CheckPhoneNumberAndPassword(long phoneNumber, String password) {
		if(String.valueOf(phoneNumber).length() != 10 || password.length() < 6) {
			return false;
		} 
		return true;
	}
	
	public Optional<User> checkUserExists(long phoneNumber) {
		return userRepository.findByPhoneNumber(phoneNumber);
	}

	@Transactional
	public User createUser(String name, long phoneNumber, String password) {
		User user = new User();
		user.setName(name);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(passwordEncoder.encode(password));
		return userRepository.save(user);
	}
	
	@Transactional
	public boolean isExistByPhoneNumberAndPasword(long phoneNumber, String password) {
		Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
		boolean isPasswordMatch = passwordEncoder.matches(password, user.get().getPassword());
		return isPasswordMatch;
	}
	
	public User findByPhoneNumber(long phoneNumber) {
		return userRepository.findByPhoneNumber(phoneNumber).get();
	}
	
	
}
