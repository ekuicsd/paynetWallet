package com.paynet.wallet.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paynet.wallet.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByPhoneNumber(long phoneNumber);
	
	User save(User user);

}
