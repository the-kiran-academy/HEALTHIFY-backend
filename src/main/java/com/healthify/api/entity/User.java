package com.healthify.api.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author RAM ADMIN DOCTOR PHARMACIST RECEPTIONIST
 */
@Entity
public class User {

	@Id
	@Column(name = "UserName")
	private String username;

	@Column(name = "FirstName")
	private String firstname;

	@Column(name = "LastName")
	private String lastname;

	
	@Column(name = "EmailId",unique = true)
	private String emailid;

	@Column(name = "Password")
	private String password;

	@Column(name = "MobileNo",unique = true)
	private String mobileno;

	@Column(name = "Street")
	private String street;

	@Column(name = "City")
	private String city;

	@Column(name = "Pincode")
	private String pincode;

	@Column(name = "type")
	private String type;

	@Column(name = "Question")
	private String Question;

	@Column(name = "Answer")
	private String answer;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "CreatedDate")
	private Date createdDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles;

	public User() {
		
	}

	public User(String username, String firstname, String lastname, String emailid, String password, String mobileno,
			String street, String city, String pincode, String type, String question, String answer, Date createdDate,
			Set<Role> roles) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.mobileno = mobileno;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.type = type;
		Question = question;
		this.answer = answer;
		this.createdDate = createdDate;
		this.roles = roles;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid="
				+ emailid + ", password=" + password + ", mobileno=" + mobileno + ", street=" + street + ", city="
				+ city + ", pincode=" + pincode + ", type=" + type + ", Question=" + Question + ", answer=" + answer
				+ ", createdDate=" + createdDate + ", roles=" + roles + "]";
	}
	
	

}
