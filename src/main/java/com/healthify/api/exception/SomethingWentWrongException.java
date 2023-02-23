package com.healthify.api.exception;

/**
 * @author RAM
 *
 */
public class SomethingWentWrongException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SomethingWentWrongException(String message) {
		super(message);
	}

}
