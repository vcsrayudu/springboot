package com.travel.transactions.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.transactions.model.Transaction;
import com.travel.transactions.services.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	//DmtResponce dmtResponce = new DmtResponce();
	
	@RequestMapping(value = "/transaction/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<Set> getTransaction(@PathVariable("groupId") String groupId) {
		logger.info("Listing specific transactions");
		Set<Transaction> transactions=transactionService.getTransaction(groupId);
		return new ResponseEntity(transactions, HttpStatus.OK);
}
	@RequestMapping(value = "/transaction/{groupId}/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Set> gettransaction(@PathVariable("groupId") String groupId,@PathVariable("userId") String userId) {
		logger.info("Listing specific transactions");
		Set<Transaction> transactions=transactionService.getTransaction(groupId,userId);
		return new ResponseEntity(transactions, HttpStatus.OK);
}
	
	
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public ResponseEntity<Transaction> createtransaction(@RequestBody Transaction transaction) {
		logger.info("Creating a transaction for user name : "+transaction.getUserId());
		Transaction  transactionCreated=transactionService.createTransaction(transaction);
		return new ResponseEntity(transactionCreated, HttpStatus.OK);
}
	@RequestMapping(value = "/transaction/{transactioId}", method = RequestMethod.PUT)
	public ResponseEntity<Transaction> updatetransaction(@PathVariable("transactionId") String transactioId, @RequestBody Transaction transaction) {
		logger.info("Updating a transaction  : "+transaction.getTransId());
		Transaction  uptransaction=transactionService.updateTransaction(transaction,transactioId);
		return new ResponseEntity(uptransaction, HttpStatus.OK);
}
	@RequestMapping(value = "/transaction/{transactionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Transaction> deletetransaction(@PathVariable("transactionId") String transactionId) {
		logger.info("Deleting a transaction: "+transactionId);
		Transaction  uptransaction=transactionService.deleteTransaction(transactionId);
		return new ResponseEntity(uptransaction, HttpStatus.OK);
}

}
