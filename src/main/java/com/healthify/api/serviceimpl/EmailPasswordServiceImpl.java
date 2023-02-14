// Java Program to Illustrate Creation Of
// Service implementation class

package com.healthify.api.serviceimpl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Otp;
import com.healthify.api.entity.User;
import com.healthify.api.model.EmailDetails;
import com.healthify.api.model.ResetPasswordDetail;
import com.healthify.api.service.EmailPasswordService;
import com.healthify.api.service.UserService;
import com.healthify.api.utility.OTPGenerator;

@Service
public class EmailPasswordServiceImpl implements EmailPasswordService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;

	@Value("${spring.mail.username}")
	private String sender;

	// Method 1
	// To send a simple email
	public boolean sendMail(EmailDetails details) {
		return false;
	}

	@Override
	public String resetPasswordByQA(ResetPasswordDetail detail) {
		return null;
	}

	@Override
	public String sendOtp(String UserId) {
		return null;
	}

	@Override
	public String resetPasswordByOtp(ResetPasswordDetail detail) {
		return null;
	}

}
