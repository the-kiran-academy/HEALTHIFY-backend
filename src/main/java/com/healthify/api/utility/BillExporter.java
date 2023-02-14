package com.healthify.api.utility;
//package com.hms.api.utility;
//
//import java.awt.Color;
//import java.io.IOException;
//import java.util.List;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.hms.api.constants.DatabaseConstants.WantMedicinesFromHospital;
//import com.hms.api.entity.Appointment;
//import com.hms.api.entity.Medicine;
//import com.hms.api.entity.MedicineCompany;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//import com.lowagie.text.pdf.draw.VerticalPositionMark;
//
//public class BillExporter {
//
//	private static Logger LOG = LogManager.getLogger(BillExporter.class);
//
//	private MedicineCompany medicineCompany;
//	private Appointment appointment;
//
//	private List<Medicine> medicines;
//
//	public BillExporter(DoctorResource doctorResource, PatientResource patientResource,
//			MedicineCompanyResource medicineCompany, MedicineResource medicineResource, Appointment appointment) {
//		super();
//		this.doctorResource = doctorResource;
//		this.patientResource = patientResource;
//		this.medicineCompany = medicineCompany;
//		this.appointment = appointment;
//		this.medicineResource = medicineResource;
//		this.medicines = this.appointment.getMedicines();
//	}
//
//	private void writeTableHeader(PdfPTable table) {
//		PdfPCell cell = new PdfPCell();
//		cell.setBackgroundColor(new Color(215, 196, 158));
//		cell.setPadding(5);
//
//		Font font = FontFactory.getFont(FontFactory.HELVETICA);
//		font.setColor(new Color(91, 73, 37));
//
//		cell.setPhrase(new Phrase("Medicine Name", font));
//
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Type", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Company", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Expiry Date", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Quantity", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Price", font));
//		table.addCell(cell);
//
//	}
//
//	private void writeTableData(PdfPTable table) {
//		for (Medicine medicine : medicines) {
//			table.addCell(medicine.getName());
//			table.addCell(medicine.getType());
//			table.addCell(medicineCompany.getCompanyById(medicine.getMedicineCompanyId()).getName());
//			table.addCell(medicine.getExpirydate());
//			table.addCell("1");
//			table.addCell(String.valueOf(medicine.getPrice()));
//		}
//	}
//
//	public void export(HttpServletResponse response) throws DocumentException, IOException {
//		Document document = new Document(PageSize.A4);
//
//		PdfWriter.getInstance(document, response.getOutputStream());
//		document.open();
//		Image image = Image.getInstance("classpath:images/logo.png");
//		image.scalePercent(10.0f, 10.0f);
//		document.add(image);
//
//		Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		headerFont.setSize(25);
//		headerFont.setColor(new Color(91, 73, 37));
//		Paragraph pHeader = new Paragraph("Hospital Bill\n", headerFont);
//		pHeader.setAlignment(Paragraph.ALIGN_CENTER);
//		document.add(pHeader);
//
//		Font fontD = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontD.setSize(13);
//		fontD.setColor(new Color(215, 196, 158));
//		Paragraph pD = new Paragraph("Appointment Id: " + appointment.getId(), fontD);
//		pD.setAlignment(Paragraph.ALIGN_RIGHT);
//		document.add(pD);
//
//		Font fontAI = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontAI.setSize(13);
//		fontAI.setColor(new Color(215, 196, 158));
//		Paragraph pAI = new Paragraph("Billing Date: " + appointment.getBillingDate(), fontAI);
//		pAI.setAlignment(Paragraph.ALIGN_RIGHT);
//		document.add(pAI);
//
//		Font fontP = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontP.setSize(18);
//		fontP.setColor(new Color(91, 73, 37));
//		Chunk glue = new Chunk(new VerticalPositionMark());
//		Paragraph pp = new Paragraph("\nPatient Details:", fontP);
//		pp.add(new Chunk(glue));
//		pp.add("Doctor Details:");
//		document.add(pp);
//
//		Font fontN = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontN.setSize(12);
//		fontN.setColor(Color.BLACK);
//		Chunk glueN = new Chunk(new VerticalPositionMark());
//		Paragraph pN = new Paragraph(
//				"Name: " + patientResource.getPatientById(appointment.getPatientid()).getFirstname(), fontN);
//		pN.add(new Chunk(glueN));
//		pN.add("Name: " + doctorResource.getDoctorById(appointment.getDoctorid()).getFirstname());
//		document.add(pN);
//
//		Font fontA = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontA.setSize(12);
//		fontA.setColor(Color.BLACK);
//		Chunk glueA = new Chunk(new VerticalPositionMark());
//		Paragraph pA = new Paragraph("Age: " + patientResource.getPatientById(appointment.getPatientid()).getAge(),
//				fontA);
//		pA.add(new Chunk(glueA));
//		pA.add("Specialist: " + doctorResource.getDoctorById(appointment.getDoctorid()).getSpecialist());
//		document.add(pA);
//
//		Font fontBG = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontBG.setSize(12);
//		fontBG.setColor(Color.BLACK);
//		Paragraph pBG = new Paragraph(
//				"Blood Group: " + patientResource.getPatientById(appointment.getPatientid()).getBloodgroup(), fontBG);
//		pBG.setAlignment(Paragraph.ALIGN_LEFT);
//		document.add(pBG);
//
//		Font fontE = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontE.setSize(12);
//		fontE.setColor(Color.BLACK);
//		Paragraph pE = new Paragraph(
//				"Email: " + patientResource.getPatientById(appointment.getPatientid()).getEmailid(), fontE);
//		pE.setAlignment(Paragraph.ALIGN_LEFT);
//		document.add(pE);
//
//		Font fontPhone = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontPhone.setSize(12);
//		fontPhone.setColor(Color.BLACK);
//		Paragraph pPhone = new Paragraph(
//				"Phone: " + patientResource.getPatientById(appointment.getPatientid()).getMobileno(), fontPhone);
//		pPhone.setAlignment(Paragraph.ALIGN_LEFT);
//		document.add(pPhone);
//
//		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font.setSize(18);
//		font.setColor(new Color(91, 73, 37));
//		Paragraph p = new Paragraph("\nAssigned Medicines\n", font);
//		p.setAlignment(Paragraph.ALIGN_CENTER);
//		document.add(p);
//
//		PdfPTable table = new PdfPTable(6);
//		table.setWidthPercentage(100f);
//		table.setWidths(new float[] { 3.0f, 2.5f, 2.5f, 2.7f, 1.5f, 1.5f });
//		table.setSpacingBefore(10);
//
//		writeTableHeader(table);
//		writeTableData(table);
//
//		document.add(table);
//
//		Font fontTook = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontTook.setSize(13);
//		fontTook.setColor(new Color(91, 73, 37));
//		Paragraph pTook = new Paragraph("\nTook Medicines From Hospital : " + appointment.getWantMedicine(), fontTook);
//		pTook.setAlignment(Paragraph.ALIGN_RIGHT);
//		document.add(pTook);
//		String medicinesPrice;
//		if (appointment.getWantMedicine().equals(WantMedicinesFromHospital.YES.value())) {
//			medicinesPrice = medicineResource.getMedicinesPrice(medicines);
//		}
//
//		else {
//			medicinesPrice = "0.0";
//		}
//
//		Font fontMedicines = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontMedicines.setSize(13);
//		fontMedicines.setColor(new Color(91, 73, 37));
//		Paragraph pMedicines = new Paragraph("\nMedicines Price: Rs " + medicinesPrice + "/-", fontMedicines);
//		pMedicines.setAlignment(Paragraph.ALIGN_RIGHT);
//		document.add(pMedicines);
//
//		Font fontTreatment = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontTreatment.setSize(13);
//		fontTreatment.setColor(new Color(91, 73, 37));
//		Paragraph pTreatment = new Paragraph("\nTreatment Price: Rs " + appointment.getTreatmentprice() + "/-",
//				fontTreatment);
//		pTreatment.setAlignment(Paragraph.ALIGN_RIGHT);
//		document.add(pTreatment);
//
//		Font fontTotalPrice = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontTotalPrice.setSize(13);
//		fontTotalPrice.setColor(new Color(91, 73, 37));
//		Paragraph pTotalPrice = new Paragraph("\nTotal Price: Rs "
//				+ medicineResource.getTotalPrice(medicinesPrice, String.valueOf(appointment.getTreatmentprice()))
//				+ "/-", fontTotalPrice);
//		pTotalPrice.setAlignment(Paragraph.ALIGN_RIGHT);
//		document.add(pTotalPrice);
//
//		document.close();
//
//	}
//
//}
