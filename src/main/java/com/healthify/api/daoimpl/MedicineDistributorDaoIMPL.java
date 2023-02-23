package com.healthify.api.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.MedicineDistributorDao;
import com.healthify.api.entity.MedicineDistributor;

/**
 * @author RAM
 *
 */
@Repository
public class MedicineDistributorDaoIMPL implements MedicineDistributorDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public MedicineDistributor addMedicineDistributor(MedicineDistributor medicineDistributor) {
		
		return null;
	}

	@Override
	public boolean deleteMedicineDistributorById(String id) {
		
		return false;
	}

	@Override
	public MedicineDistributor getMedicineDistributorById(String id) {
		
		return null;
	}

	@Override
	public MedicineDistributor updateMedicineDistributor(MedicineDistributor medicineDistributor) {
		return null;
	}

	@Override
	public List<MedicineDistributor> getAllDistributors() {
		return null;
	}

	@Override
	public List<MedicineDistributor> getDistributorsByName(String distributorName) {
		return null;
	}

	@Override
	public MedicineDistributor getDistributorByName(String distributorName) {
		return null;
	}

	@Override
	public Long getCountByRegisteredDate(String date) {
		return null;
	}

	@Override
	public List<MedicineDistributor> getTop5CompanyAddedByDate(String date) {
		return null;
	}

}
