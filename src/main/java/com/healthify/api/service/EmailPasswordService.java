package com.healthify.api.service;

import org.springframework.transaction.annotation.Transactional;

import com.healthify.api.model.EmailDetails;
import com.healthify.api.model.ResetPasswordDetail;

@Transactional
public interface EmailPasswordService {

	boolean sendMail(EmailDetails details);

	String sendOtp(String UserId);

	String resetPasswordByOtp(ResetPasswordDetail detail);

	String resetPasswordByQA(ResetPasswordDetail detail);

}
