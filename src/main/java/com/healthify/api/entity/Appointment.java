package com.healthify.api.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author RAM
 *
 */
@Entity
public class Appointment {
	@Id
	@Column(name = "AppointmentPatientId")
	private String appointmentpatientid;
	
	@Column(name = "DoctorId")
	private String doctorid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "AppointmentTakenDate")
    private Date appointmenttakendate;
	
	@Column(name = "AppointmentTakenTime")
	private String appointmenttakentime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "AppointmentDate")
	private Date appointmentdate;
	
	
	@Column(name = "AppointmentTime")
	private String appointmenttime;
	
	@Column(name = "ProblemDescription")
	private String problemdescription;
	
	@Column(name = "TreatmentStatus",nullable = false, columnDefinition = "varchar(255) default 'Pending'")
	private String treatmentstatus;
	
	@Column(name = "TreatmentCost")
	private double treatmentCost;
	
	@Column(name = "BillMade")
	private String billMade;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "BillingDate")
	private Date billingDate;

	
	public String getAppointmentpatientid() {
		return appointmentpatientid;
	}

	public void setAppointmentpatientid(String appointmentpatientid) {
		this.appointmentpatientid = appointmentpatientid;
	}

	public String getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public Date getAppointmenttakendate() {
		return appointmenttakendate;
	}

	public void setAppointmenttakendate(Date appointmenttakendate) {
		this.appointmenttakendate = appointmenttakendate;
	}

	public String getAppointmenttakentime() {
		return appointmenttakentime;
	}

	public void setAppointmenttakentime(String appointmenttakentime) {
		this.appointmenttakentime = appointmenttakentime;
	}

	public Date getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(Date appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getAppointmenttime() {
		return appointmenttime;
	}

	public void setAppointmenttime(String appointmenttime) {
		this.appointmenttime = appointmenttime;
	}

	public String getProblemdescription() {
		return problemdescription;
	}

	public void setProblemdescription(String problemdescription) {
		this.problemdescription = problemdescription;
	}

	public String getTreatmentstatus() {
		return treatmentstatus;
	}

	public void setTreatmentstatus(String treatmentstatus) {
		this.treatmentstatus = treatmentstatus;
	}

	

	public double getTreatmentprice() {
		return treatmentCost;
	}

	public void setTreatmentprice(double treatmentprice) {
		this.treatmentCost = treatmentprice;
	}

	public String getBillMade() {
		return billMade;
	}

	public void setBillMade(String billMade) {
		this.billMade = billMade;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	
	
}