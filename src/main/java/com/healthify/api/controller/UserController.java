package com.healthify.api.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.healthify.api.entity.User;
import com.healthify.api.exception.ResourceNotFoundException;
import com.healthify.api.service.UserService;


/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	private static Logger LOG = LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping(value = "get-user-by-id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id) {
		return null;
	}
@GetMapping(value = "get-user-by-fistname/{name}")
	public ResponseEntity <List<User>> getUserByFirstName(@PathVariable String name)
	{
	List<User> user =userService.getUserByFirstName(name);
	if(user!=null && !user.isEmpty())
	{
	return new ResponseEntity <List<User>>(user,HttpStatus.OK);
	}
	else{
		Log.info("Resource Not Found ");
		throw new  ResourceNotFoundException(" Resource Not Found ");
		
	}
	}
}