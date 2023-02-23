package com.healthify.api.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.MedicineDao;
import com.healthify.api.entity.Medicine;

/**
 * @author RAM
 *
 */
@Repository
public class MedicineDaoIMPL implements MedicineDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Medicine addMedicine(Medicine medicine) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> findByNameContainingIgnoreCase(String medicineName) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Medicine findByName(String medicineName) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> findByQuantityGreaterThan(int quantity) {
		return null;
	}

	@Override
	public Long countByDateAdded(String dateAdded) {
		return null;
	}

	@Override
	public Long getTotalCount() {
		return null;
	}


	@Override
	public List<Medicine> findTop5ByIdDesc(String date) {
		return null;
	}

	
	@Override
	public boolean deleteMedicineById(String id) {
		return false;

	}

	@Override
	public Medicine getMedicineById(String id) {
		return null;
	}

	
	@Override
	public Medicine updateMedicine(Medicine medicine) {
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> getAllMedicine() {
		return null;
	}

}
