package com.healthify.api.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TransactionDetails {

	@Id
	private String transactionId;

	private int month;
	private String name;
	private String designation;

	private int noOfDays;
	private int prasentDays;
	private int leaves;

	private float basic;
	private float dearnessAllowance;
	private float houserentAllowance;
	private float conveyanceAllowance;
	private float medicalAllowance;
	private float specialAllowance;
	private float totalPay;
	private float pf;
	private float tds;
	private float epf;
	private float deductionTotal;
	private float totalPayForTheMonth;
	private float professionalTax;

	private float netSalary;
	private float grossSalary;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_transaction", joinColumns = { @JoinColumn(name = "TRANSACTION_ID") }, inverseJoinColumns = {
//			@JoinColumn(name = "USER_ID") })
//	private Set<User> user;

	private String username;

	public TransactionDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getPrasentDays() {
		return prasentDays;
	}

	public void setPrasentDays(int prasentDays) {
		this.prasentDays = prasentDays;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	public float getBasic() {
		return basic;
	}

	public void setBasic(float basic) {
		this.basic = basic;
	}

	public float getDearnessAllowance() {
		return dearnessAllowance;
	}

	public void setDearnessAllowance(float dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public float getHouserentAllowance() {
		return houserentAllowance;
	}

	public void setHouserentAllowance(float houserentAllowance) {
		this.houserentAllowance = houserentAllowance;
	}

	public float getConveyanceAllowance() {
		return conveyanceAllowance;
	}

	public void setConveyanceAllowance(float conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}

	public float getMedicalAllowance() {
		return medicalAllowance;
	}

	public void setMedicalAllowance(float medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}

	public float getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(float specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public float getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(float totalPay) {
		this.totalPay = totalPay;
	}

	public float getPf() {
		return pf;
	}

	public void setPf(float pf) {
		this.pf = pf;
	}

	public float getTds() {
		return tds;
	}

	public void setTds(float tds) {
		this.tds = tds;
	}

	public float getEpf() {
		return epf;
	}

	public void setEpf(float epf) {
		this.epf = epf;
	}

	public float getDeductionTotal() {
		return deductionTotal;
	}

	public void setDeductionTotal(float deductionTotal) {
		this.deductionTotal = deductionTotal;
	}

	public float getTotalPayForTheMonth() {
		return totalPayForTheMonth;
	}

	public void setTotalPayForTheMonth(float totalPayForTheMonth) {
		this.totalPayForTheMonth = totalPayForTheMonth;
	}

	public float getProfessionalTax() {
		return professionalTax;
	}

	public void setProfessionalTax(float professionalTax) {
		this.professionalTax = professionalTax;
	}

	public float getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}

	public float getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
