package com.healthify.api.service;

import org.springframework.transaction.annotation.Transactional;

import com.healthify.api.entity.TransactionDetails;


@Transactional
public interface TransactionService {

	public int generateSalaryForUser(TransactionDetails transactionDetails);

	public String generateSalaryreportForUser(String username, int from, int to);

}
