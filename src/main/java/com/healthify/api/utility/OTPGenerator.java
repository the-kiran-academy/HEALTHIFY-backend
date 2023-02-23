package com.healthify.api.utility;

import java.util.Random;

public class OTPGenerator {

	public static int generateOtp() {
		Random random = new Random();
		String numbers = "123456789";
		char[] otp = new char[6];

		for (int i = 0; i < 6; i++) {

			otp[i] = numbers.charAt(random.nextInt(numbers.length()));
		}

		return Integer.parseInt(new String(otp));

	}

}
