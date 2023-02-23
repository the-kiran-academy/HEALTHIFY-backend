package com.healthify.api.serviceimpl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.TransactionDao;
import com.healthify.api.entity.TransactionDetails;
import com.healthify.api.service.TransactionService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class TransactionServiceIMPL implements TransactionService {

	@Autowired
	private TransactionDao dao;

	@Override
	public int generateSalaryForUser(TransactionDetails transactionDetails) {
		
		return dao.generateSalaryForUser(transactionDetails);
	}

	@Override
	public String generateSalaryreportForUser(String username, int from, int to) {
		String path = null;
		return path;
	}

}
