package com.healthify.api.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * @author RAM
 *
 */
@Entity
public class Otp {
	
	@Id
	private String userId;
	private int otp;
	private Timestamp timestamp;
	
	public Otp() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int generatedOtp) {
		this.otp = generatedOtp;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
	
}
