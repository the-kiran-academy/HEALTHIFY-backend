package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.AppointmentDao;
import com.healthify.api.entity.Appointment;
import com.healthify.api.service.AppointmentService;

/**
 * @author RAM
 *
 */
@Service()
public class AppointmentServiceImp implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public Appointment addAppointment(Appointment appointment) {

		return null;
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return null;
	}

	@Override
	public Appointment getAppointmentById(String appointmentId) {
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsByPatientsIds(List<String> patientsId) {
		
		
		
		
		return appointmentDao.getAppointmentsByPatientsIds(patientsId);
	}

	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate) {
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate,
			String appointmentTime) {
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsByDate(Date date) {
		return appointmentDao.getAppointmentsByDate(date);
	}

	@Override
	public Long getCountByAppointmentDate(Date appointmentDate) {
		return null;
	}
	@Override
	public List<Appointment> getAppointmentsByBillingDate(Date billingDate) {
		
		return appointmentDao.getAppointmentsByBillingDate(billingDate);
	}

	@Override
	public Long getAppointmentsTotalCount() {
		return null;
	}

	@Override
	public Long getCountByAppointmentTakenDate(Date appointmentTakenDate) {
		return null;
	}

	@Override
	public Long getCountByTreatmentStatusAndBillingDate(String treatmentStatus, Date billingDate) {
		return null;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return null;
	}

	@Override
	public List<Appointment> getTop5AppointmentsByDate(Date date) {
		return null;
	}

}
