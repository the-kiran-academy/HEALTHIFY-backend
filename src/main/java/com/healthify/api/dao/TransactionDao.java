package com.healthify.api.dao;

import java.util.List;

import com.healthify.api.entity.TransactionDetails;


public interface TransactionDao {
	public int generateSalaryForUser(TransactionDetails transactionDetails);

	public com.healthify.api.entity.TransactionDetails getTransactionDetails(String transactionId);
	
	public TransactionDetails getTransactionDetails(String username,int month);

	public List<TransactionDetails> getTransactionDetails(String username, int from, int to);
	
	

}
