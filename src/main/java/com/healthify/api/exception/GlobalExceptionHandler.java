package com.healthify.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author RAM
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> badCredentialsException(BadCredentialsException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);

	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> invalidCredientials(InvalidCredentialsException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<String> resourceAlreadyExists(ResourceAlreadyExistsException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}


	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<String> somethingWentWrongException(SomethingWentWrongException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}

}
