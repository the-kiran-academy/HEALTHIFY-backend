package com.healthify.api.daoimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.PatientDao;
import com.healthify.api.entity.Patient;

/**
 * @author RAM
 *
 */
@Repository
@SuppressWarnings({ "deprecation", "unchecked" })
public class PatientDaoIMPL implements PatientDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Patient> findByFirstnameContainingIgnoreCase(String patientName) {

		return null;
	}

	@Override
	public Long getPatientsCount() {

		return null;
	}

	@Override
	public Long getPatientsCountByDate(Date registeredDate) {

		return null;
	}

	@Override
	public List<Patient> getTop5PatientAddedByDate() {
		return null;
	}

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
	public List<Patient> getAllPatients() {
		return null;
	}

	@Override
	public List<String> getAllPatientsIds() {
		return null;
	}

}