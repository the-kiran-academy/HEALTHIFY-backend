package com.healthify.api.controller;

import java.sql.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.entity.Appointment;
import com.healthify.api.exception.ResourceNotFoundException;

import com.healthify.api.service.AppointmentService;

/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;

	private static Logger LOG = LogManager.getLogger(AppointmentController.class);

	@PostMapping(value = "/add-appointment")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
		return null;

	}

	@PutMapping(value = "/update-appointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-id/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
		Appointment isPresent = service.getAppointmentById(id);
		if(isPresent != null) {
			return new ResponseEntity<Appointment>(isPresent,HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Resource Not Found !");
		}
	}

	@GetMapping(value = "/get-appointment-by-ids")
	public ResponseEntity<List<Appointment>> getAppointmentsByPatientsIds(@RequestParam List<String> ids) {
		  
	List<Appointment> appointmentList=	service.getAppointmentsByPatientsIds(ids);
		if(!appointmentList.isEmpty()){
			return new ResponseEntity<List<Appointment>>(appointmentList, HttpStatus.OK);
		}else{
			throw new ResourceNotFoundException("Appointments with Given Ids are not present");
		}
		
	}

	@GetMapping(value = "/get-appointment-by-drid-apointmentdate/{drid}/{date}")
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorIdAndAppointmentDate(@PathVariable String drid,
			@PathVariable Date date) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-drid-and-apointmentdate-and-time")
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorIdAndAppointmentDate(@RequestParam String doctorId,
			@RequestParam Date appointmentDate, @RequestParam String appointmentTime) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-apointmentdate")
	public ResponseEntity<List<Appointment>> getAppointmentsByDate(@RequestParam Date appointmentDate)  {
		List<Appointment> list = service.getAppointmentsByDate(appointmentDate);
			if (!list.isEmpty()) {
				 return new ResponseEntity<List<Appointment>>(list, HttpStatus.OK);
				}else {
					throw new ResourceNotFoundException("Resource not found") ;
				}
	}
	

	@GetMapping(value = "/get-count-by-appointment-date/{date}")
	public ResponseEntity<Long> getCountByAppointmentDate(@RequestParam Date date) {
		
		Long count = service.getCountByAppointmentDate(date);
		
		if(count > 0) {
			return new ResponseEntity<Long>(count,HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Appointment doesnt exist with this date!");
		}
	}

	@GetMapping(value = "/get-appointment-by-billingdate")
	public ResponseEntity<List<Appointment>> getAppointmentsByBillingDate(@RequestParam Date billingDate) {
		List<Appointment> list = service.getAppointmentsByBillingDate(billingDate);
		
		if(!list.isEmpty()) {
			
			return new ResponseEntity<List<Appointment>>(list, HttpStatus.OK);
		}
		else {
			
			LOG.info("Resource Not Found");
			
			throw new ResourceNotFoundException("Resource Not Found");
		}
	}

	@GetMapping(value = "/get-count-of-appointments")
	public ResponseEntity<Long> getAppointmentsTotalCount() {
		return null;
	}

	@GetMapping(value = "/get-count-by-appointmenttaken-date")
	public ResponseEntity<Long> getCountByAppointmentTakenDate(@RequestParam Date appointmentTakenDate) {
		return null;
	}

	@GetMapping(value = "/get-count-by-treatmentstatus-and billingdate")
	public ResponseEntity<Long> getCountByTreatmentStatusAndBillingDate(@RequestParam String treatmentStatus,
			@RequestParam Date billingDate) {
		return null;
	}

	@GetMapping(value = "/get-all-appointments")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		return null;
	}

	@GetMapping(value = "/get-top5-appointments")
	public ResponseEntity<List<Appointment>> getTop5AppointmentsByDate(@RequestParam Date date) {
		return null;
	}
}
