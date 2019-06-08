package com.travel.transactions.services;



import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travel.transactions.model.Transaction;
import com.travel.transactions.model.TransactionRepo;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepo trxRepository;
	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	@Override
	public Transaction createTransaction(Transaction trx) {
		// TODO Auto-generated method stub
		logger.info("Transaction is creating for group: "+trx.getGroupId());
		var randomnumber=new Date().getTime();
		var rand = Math.floor((Math.random() * randomnumber) + 1); 
		String transId=trx.getGroupId()+trx.getUserId()+rand;
		logger.info("Transaction Id: "+transId);
		trx.setTransId(transId);
		Transaction create=trxRepository.save(trx);
		if(create!=null)
		{
			logger.info("Transaction created for group: "+trx.getGroupId());
			return create;
		}
		
		return null;
	}

	@Override
	public Set<Transaction> getTransaction(String groupId) {
		// TODO Auto-generated method stub
		logger.info("Retriving Transactions for group: "+groupId);
		Set<Transaction> trxList=trxRepository.findByGroupId(groupId);
		if(trxList!=null)
		logger.info("Retrived Transactions for group: "+groupId);
		return trxList;
	}

	@Override
	public Set<Transaction> getTransaction(String groupId, String userId) {
		// TODO Auto-generated method stub
		logger.info("Retriving Transactions for group: "+groupId);
		Set<Transaction> trxList=trxRepository.findByGroupId(groupId);
		Set<Transaction> trxListByUser=new HashSet<Transaction>();
		for(Transaction trx:trxList)
		{
			if(trx.getUserId().equals(userId))
				trxListByUser.add(trx);
		}
		if(trxList!=null)
		logger.info("Retrived Transactions for user: "+userId);
		return trxListByUser;
		
	}

	@Override
	public Transaction updateTransaction(Transaction trx, String trxId) {
		// TODO Auto-generated method stub
		logger.info("Retriving Transactions to Update: "+trxId);
		
		Transaction transation=trxRepository.findByTransId(trxId);
		logger.info("Updating Transaction values for : "+trxId);
		
		transation.setCause(trx.getCause());
		transation.setDate(trx.getDate());
		transation.setExpence(trx.getExpence());
		transation.setGroupId(trx.getGroupId());
		transation.setUserId(trx.getTransId());
		transation=trxRepository.save(transation);
		logger.info("Updated Transaction is saved:  "+trxId);
		
		return transation;
	}

	@Override
	public Transaction deleteTransaction(String trxId) {
		// TODO Auto-generated method stub
		logger.info("Retriving Transactions to Delete: "+trxId);
		Transaction trx=trxRepository.findByTransId(trxId);
		trxRepository.delete(trx);
		logger.info("Deleted Transaction : "+trxId);
		return null;
	}

}
