package com.healthify.api.controller;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.entity.Patient;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.exception.ResourceNotFoundException;
import com.healthify.api.service.PatientService;

/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/patient")
public class PatientController {

	private static Logger LOG = LogManager.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	@PostMapping(value = "/add-patient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {

		return null;
	}

	@DeleteMapping(value = "/delete-patient-by-id/{id}")
	public ResponseEntity<String> deletePatientById(@PathVariable String id) {

		return null;

	}

	@GetMapping(value = "/get-patient-by-id/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable String id) {

		return null;

	}

	@PutMapping(value = "/update-patient")
	public ResponseEntity<String> updatePatient(@RequestBody Patient patient) {

		return null;
	}

	@GetMapping(value = "/get-all-patient")
	public ResponseEntity<List<Patient>> getAllPatient() {

		return null;
	}

	@GetMapping(value = "/get-patientsId-by-patientname/{name}")
	public ResponseEntity<List<Patient>> findByFirstnameContainingIgnoreCase(@PathVariable String name) {
		return null;
	}

	@GetMapping(value = "/get-total-count-of-patient")
	public ResponseEntity<Long> getPatientsCount() {

		return null;
	}

	@GetMapping(value = "/count-by-registerdate")
	public ResponseEntity<Long> getPatientsCountByDate(Date registeredDate) {

		return null;


	}

	@GetMapping(value = "/top5-patients-by-date")
	public ResponseEntity<List<Patient>> getTop5PatientAddedByDate() {

		return null;

	}

	@GetMapping(value = "/get-all-patients-ids")
	public ResponseEntity<List<String>> getAllPatientsIds() {

		return null;
		
	}

}
