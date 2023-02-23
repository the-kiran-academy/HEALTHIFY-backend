package com.healthify.api.service;

import java.sql.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.healthify.api.entity.Patient;

/**
 * @author RAM
 *
 */
@Transactional
public interface PatientService {
	Patient addPatient(Patient patient);

	boolean deletePatientById(String id);

	Patient getPatientById(String id);

	Patient updatePatient(Patient patient);

	List<Patient> getAllPatients();

	List<Patient> findByFirstnameContainingIgnoreCase(String patientname);

	Long getPatientsCount();

	Long getPatientsCountByDate(Date registerDate);

	List<Patient> getTop5PatientAddedByDate();

	List<String> getAllPatientsIds();
}
