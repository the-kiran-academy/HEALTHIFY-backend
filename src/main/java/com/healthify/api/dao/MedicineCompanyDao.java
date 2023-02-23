package com.healthify.api.dao;

import java.util.List;

import com.healthify.api.entity.MedicineCompany;

/**
 * @author RAM
 *
 */
public interface MedicineCompanyDao {
	
	List<MedicineCompany> findByNameContainingIgnoreCase(String companyName);
	MedicineCompany findByName(String companyName);
	Long countByRegisterdate(String dateAdded);
	public List<MedicineCompany> findTop5ByIdDesc(String date);
	public MedicineCompany addMedicineCompany(MedicineCompany medicineCompany);
	public boolean deleteMedicineCompanyById (String id);
	public MedicineCompany getMedicineCompanyById (String id);
	public MedicineCompany updateMedicineCompany(MedicineCompany medicineCompany);
	public List<MedicineCompany> getAllMedicineCompanys();
}
