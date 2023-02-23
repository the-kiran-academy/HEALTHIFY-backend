package com.healthify.api.daoimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CountProjection;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.AppointmentDao;
import com.healthify.api.entity.Appointment;
import com.healthify.api.exception.ResourceNotFoundException;

/**
 * @author RAM
 *
 */
@Repository
public class AppointmentDaoIMPL implements AppointmentDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		return null;
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return null;
	}

	@Override
	public Appointment getAppointmentById(String patientId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByPatientsIds(List<String> patientIds) {

		List<Appointment> appointmentList = new ArrayList<Appointment>();
		Session session = sf.getCurrentSession();

		try {
			for (String Id : patientIds) {

				Appointment dbAppointment = session.get(Appointment.class, Id);

				if (dbAppointment != null) {
					appointmentList.add(dbAppointment);
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return appointmentList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate,
			String appointmentTime) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByDate(Date date) {
		Session session = sf.getCurrentSession();
		List<Appointment> list = null;
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Appointment> query = cb.createQuery(Appointment.class);
			Root<Appointment> root = query.from(Appointment.class);
			query.select(root).where(cb.equal(root.get("appointmentdate"), date));
			list = session.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return list;
	}
	@Override
	public Long getCountByAppointmentDate(Date appointmentDate) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAppointmentsByBillingDate(Date billingDate) {
		
		Session session = sf.getCurrentSession();
		List<Appointment> appointmentsByBillingDate=null;
		try {
			Criteria criteria = session.createCriteria(Appointment.class);
			criteria.add(Restrictions.eq("billingDate",billingDate));
			 appointmentsByBillingDate = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return appointmentsByBillingDate;
	}

	@Override
	public Long getAppointmentsTotalCount() {
		Long AppointmentCount = null;
		Session session = sf.getCurrentSession();

		try {

			Criteria criteria = session.createCriteria(Appointment.class);
			criteria.add(Restrictions.eq("treatmentstatus", "pending"));
			CountProjection projections = Projections.count("treatmentstatus");
			criteria.setProjection(projections);
			AppointmentCount = new Long((long) criteria.uniqueResult());
			// System.err.println(AppointmentCount);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return AppointmentCount;
		
	}

	@Override
	public Long getCountByAppointmentTakenDate(Date appointmentTakenDate) {
		return null;
	}

	@Override
	public Long getCountByTreatmentStatusAndBillingDate(String treatmentStatus, Date billingDate) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAllAppointments() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getTop5AppointmentsByDate(Date date) {
		return null;
	}

}
