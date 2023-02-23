package com.healthify.api.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.TransactionDao;
import com.healthify.api.entity.TransactionDetails;


@Repository
public class TransactionDaoIMPL implements TransactionDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public int generateSalaryForUser(TransactionDetails transactionDetails) {
		Session session = sf.getCurrentSession();

		int status = 0;
		
		return status;
	}

	@Override
	public TransactionDetails getTransactionDetails(String transactionId) {
		Session session = sf.getCurrentSession();
		TransactionDetails transactionDetails = null;
		
		return transactionDetails;

	}

	@Override
	public TransactionDetails getTransactionDetails(String username, int month) {
		Session session = sf.getCurrentSession();
		List<TransactionDetails> list = null;
		TransactionDetails transactionDetails = null;
		
		return transactionDetails;
	}

	@Override
	public List<TransactionDetails> getTransactionDetails(String username, int from, int to) {
		List<TransactionDetails> list = null;
		Session session = sf.getCurrentSession();
		
		return list;
	}

}