package com.healthify.api.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.entity.User;
import com.healthify.api.exception.InvalidCredentialsException;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.model.JwtResponse;
import com.healthify.api.model.ResetPasswordDetail;
import com.healthify.api.security.CustomUserDetail;
import com.healthify.api.security.CustomUserDetailService;
import com.healthify.api.service.EmailPasswordService;
import com.healthify.api.service.UserService;
import com.healthify.api.utility.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private static Logger LOG = LogManager.getLogger(AuthController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	EmailPasswordService emailPasswordService;

	@Autowired
	private AuthenticationManager authenticationManager;

	// completed
	@PostMapping("/login-user")
	public ResponseEntity<?> loginAdmin(@RequestBody User user,HttpServletResponse response) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtUtil.generateToken(authentication); 
        response.addHeader("token", token);
       return ResponseEntity.ok(new JwtResponse(token));
    
    }

	// send otp api is in email cotroller

	@PostMapping(value = "/reset-password-by-qa")
	public ResponseEntity<String> resetPasswordByQA(@RequestBody ResetPasswordDetail detail) {
		return null;

	}

	@PostMapping(value = "/reset-password-by-otp")
	public ResponseEntity<String> resetPasswordByOtp(@RequestBody ResetPasswordDetail detail) {
		return null;
	}

}
