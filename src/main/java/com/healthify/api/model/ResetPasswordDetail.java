package com.healthify.api.model;

public class ResetPasswordDetail {

	private String userId;
	private String question;
	private String answer;
	private String newPassword;
	private String confirmPassword;

	private int otp;

	public ResetPasswordDetail() {
		// TODO Auto-generated constructor stub
	}

	public ResetPasswordDetail(String userId, String question, String answer, String newPassword,
			String confirmPassword, int otp) {
		super();
		this.userId = userId;
		this.question = question;
		this.answer = answer;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
		this.otp = otp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	

}
