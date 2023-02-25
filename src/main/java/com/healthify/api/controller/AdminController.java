package com.healthify.api.controller;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.exception.ResourceNotFoundException;
import com.healthify.api.service.UserService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	private static Logger LOG = LogManager.getLogger(AdminController.class);

	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/add-user")
	public ResponseEntity<Boolean> registerUser(@RequestBody User user) {
		boolean isAdded = userService.addUser(user);
		
		if(isAdded) {
			return new ResponseEntity<Boolean>(isAdded,HttpStatus.CREATED);
		}else {
			throw new ResourceAlreadyExistsException("Allready exists!!");
		}
		
	}

	@DeleteMapping(value = "/delete-user/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
		return null;
		
	}

	@PutMapping("/update-user")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		
		User updatedUser = userService.updateUser(user);
		
		if(updatedUser!=null) {
			
			LOG.info("User is Updated for the username ->"+user.getUsername());
			return new ResponseEntity<>("Update user resource in database successfully..",
                                               HttpStatus.OK);
		}
		else {
			
			//LOG.info("Username "+user.getUsername()+" Not Found For Update Record.");
			throw new ResourceNotFoundException("Username "+user.getUsername()+" Not Found For Update Record.");
		}
	
	}

	@GetMapping(value = "get-all-user", produces = "application/json")
	public ResponseEntity<List<User>> getAllAdmin() {
		List<User> allUsers = userService.getAllUsers();
		if(!allUsers.isEmpty()) {
			return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("resource not found");
		}	
	}

	@PostMapping(value = "/add-role")
	public ResponseEntity<Object> addRole(@RequestBody Role role) {
		return null;
		
	}

	@GetMapping(value = "/get-role-by-id/{roleId}")
	public ResponseEntity<Role> getRoleById(@PathVariable int roleId) {
		return null;
		
	}

	@GetMapping(value = "/get-total-count-of user")
	public ResponseEntity<Long> getUsersTotalCounts() {
		return null;
		
	}

	@GetMapping(value = "/get-total-count-of-user-by-type/{type}")
	public ResponseEntity<Long> getUsersTotalCountsByType(@PathVariable String type) {
		return null;
		
	}

	@GetMapping(value = "/get-total-count-of-user-by-date-and-type/{date}/{type}")
	public ResponseEntity<Long> getUserCountByDateAndType(@PathVariable Date date, @PathVariable String type) {
		
		Long count = userService.getUserCountByDateAndType(date, type);
		
		if(count>0) {
			return new ResponseEntity<Long>(count, HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("User not exist for type as "+type+" and Registered date as "+date);
		}
		
	}

	@GetMapping(value = "/get-user-by-firtname/{firstName}", produces = "application/json")
	public ResponseEntity<List<User>> getUserByFirstName(@PathVariable String firstName) {
		return null;
		
	}

	@GetMapping(value = "/user/report")
	public String generateReport() {
		return null;

		

	}

}
