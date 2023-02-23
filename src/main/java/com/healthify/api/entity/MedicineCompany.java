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
public class MedicineCompany {
	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Name")
	private String name;

	@Column(name = "EmailId")
	private String emailid;

	@Column(name = "MobileNo")
	private String mobileNo;

	@Column(name = "Street")
	private String street;

	@Column(name = "City")
	private String city;

	@Column(name = "Pincode")
	private String pincode;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "RegisterDate")
	private Date registerDate;

	public MedicineCompany() {
		// TODO Auto-generated constructor stub
	}

	public MedicineCompany(String id, String name, String emailid, String mobileNo, String street, String city,
			String pincode, Date registerDate) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.mobileNo = mobileNo;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.registerDate = registerDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}
