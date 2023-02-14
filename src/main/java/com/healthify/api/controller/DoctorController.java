package com.healthify.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.entity.Patient;


/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
	
	private static Logger LOG = LogManager.getLogger(DoctorController.class);
	
	
	
}
