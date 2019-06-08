package com.travel.transactions.services;

import java.util.Set;

import com.travel.transactions.model.Transaction;

public interface TransactionService {
public Transaction createTransaction(Transaction trx);
public Set<Transaction> getTransaction(String groupId);
public Set<Transaction> getTransaction(String groupId,String userId);
public Transaction updateTransaction(Transaction trx, String trxId);
public Transaction deleteTransaction(String trxId);

}
