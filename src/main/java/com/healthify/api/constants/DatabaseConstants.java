package com.healthify.api.constants;

public final class DatabaseConstants {
	
	/**
	 * @author RAM
	 *
	 */
	public enum MedicineType {
		LIQUID("Liquid"),
		TABLET("Tablet"),
		CAPSULES("Capsules"),
		DROPS("Drops"),
		INHALERS("Inhalers"),
		INJECTIONS("Injections");
		
		private String type;

	    private MedicineType(String type) {
	      this.type = type;
	    }

	    public String value() {
	      return this.type;
	    }

	    public boolean equals(String type) {
	      return this.type.equals(type.toUpperCase());
	    }
	}

	public enum DoctorSpecialist {
		
		IMMUNOLOGISTS("Immunologists"),
		ANESTHESIOLOGISTS("Anesthesiologists"),
		CARDIOLOGISTS("Cardiologists"),
		DERMATOLOGISTS("Dermatologists"),
		ENDOCRINNOLOGISTS("Endocrinologists"),
		GASTROENTEROLOGISTS("Gastroenterologists"),
		HEMATOLOGISTS("Hematologists");
		
		private String type;

	    private DoctorSpecialist(String type) {
	      this.type = type;
	    }

	    public String value() {
	      return this.type;
	    }

	    public boolean equals(String type) {
	      return this.type.equals(type.toUpperCase());
	    }
	}
	
	public enum BloodGroup {
		A_POSITIVE("A+"),
		A_NEGATIVE("A-"),
		B_POSITIVE("B+"),
		B_NEGATIVE("B-"),
		O_POSITIVE("O+"),
		O_NEGATIVE("O-"),
		AB_POSITIVE("AB+"),
		AB_NEGATIVE("AB-");
		
		private String type;

	    private BloodGroup(String type) {
	      this.type = type;
	    }

	    public String value() {
	      return this.type;
	    }

	    public boolean equals(String type) {
	      return this.type.equals(type.toUpperCase());
	    }
	}
	
	public enum TreatmentStatus {
		DONE("Done"),
		PENDING("Pending");
		
		private String type;

	    private TreatmentStatus(String type) {
	      this.type = type;
	    }

	    public String value() {
	      return this.type;
	    }
	     
	}
	
	public enum AppointmentTiming {
		NINE_TO_TEN_AM("09:00 - 10:00 am"),
		TEN_TO_ELEVEN_AM("10:00 - 11:00 am"),
		ELEVEN_TO_TWELLVE_AM("11:00 - 12:00 am"),
		TWELVE_TO_ONE_PM("12:00 - 01:00 pm"),
		ONE_TO_TWO_PM("01:00 - 02:00 pm"),
		TWO_TO_THREE_PM("02:00 - 03:00 pm"),
		THREE_TO_FOUR_PM("03:00 - 04:00 pm"),
		FOUR_TO_FIVE_PM("04:00 - 05:00 pm"),
		FIVE_TO_SIX_PM("05:00 - 06:00 pm");
		
		private String time;

	    private AppointmentTiming(String time) {
	      this.time = time;
	    }

	    public String value() {
	      return this.time;
	    }
	     
	}
	
	public enum WantMedicinesFromHospital {
		YES("Yes"),
		NO("No");
		
		private String type;

	    private WantMedicinesFromHospital(String type) {
	      this.type = type;
	    }

	    public String value() {
	      return this.type;
	    }
	     
	}
	
	public enum BillMade {
		YES("Yes"),
		NO("No");
		
		private String type;

	    private BillMade(String type) {
	      this.type = type;
	    }

	    public String value() {
	      return this.type;
	    }
	     
	}
	
	public enum AdminView {
		DASHBOARD("dashboard"),
		APPOINTMENT("appointment"),
		MEDICINE("medicine"),
		DOCTOR("doctor"),
		RECEPTIONIST("receptionist"),
		PHARMACIST("pharmacist"),
		PATIENT("patient"),
		EARNING("earning");
		
		private String type;

	    private AdminView(String type) {
	      this.type = type;
	    }

	    public String value() {
	      return this.type;
	    }
	     
	}
	
	
	
}
