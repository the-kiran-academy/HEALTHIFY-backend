package com.healthify.api.dao;

import java.util.List;

import com.healthify.api.entity.MedicineDistributor;

/**
 * @author RAM
 *
 */
public interface MedicineDistributorDao {
	public MedicineDistributor addMedicineDistributor(MedicineDistributor medicineDistributor);
	public boolean deleteMedicineDistributorById(String id);
	public MedicineDistributor getMedicineDistributorById(String id);
	public MedicineDistributor updateMedicineDistributor(MedicineDistributor medicineDistributor);
	public List<MedicineDistributor> getAllDistributors();
	public List<MedicineDistributor> getDistributorsByName(String distributorName);
	public MedicineDistributor getDistributorByName(String distributorName);
	public Long getCountByRegisteredDate(String date);
	public List<MedicineDistributor> getTop5CompanyAddedByDate(String date);
}
