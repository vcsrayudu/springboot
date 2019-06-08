package com.travel.transactions.model;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface TransactionRepo extends MongoRepository<Transaction, String> {
	
	
	  //public User findByDeparture(String departure);
	  public Set<Transaction> findByGroupId(String groupId);
	 
	  public Transaction findByTransId(String trxId);

	

}
