package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.PatientDao;
import com.healthify.api.entity.Patient;
import com.healthify.api.service.PatientService;

/**
 * @author RAM
 *
 */
@Service
public class PatientServiceImp implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	public Patient addPatient(Patient patient) {
		return null;
	}

	@Override
	public boolean deletePatientById(String id) {
		return false;
	}

	@Override
	public Patient getPatientById(String id) {
		return null;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return null;
	}

	@Override
	public List<Patient> findByFirstnameContainingIgnoreCase(String patientname) {
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		return null;
	}

	@Override
	public Long getPatientsCount() {
		return null;
	}

	@Override
	public Long getPatientsCountByDate(Date registerDate) {
		return null;
	}

	@Override
	public List<Patient> getTop5PatientAddedByDate() {
		return null;
	}

	@Override
	public List<String> getAllPatientsIds() {
		return null;
	}

}
