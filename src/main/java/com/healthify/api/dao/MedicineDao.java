package com.healthify.api.dao;

import java.util.List;

import com.healthify.api.entity.Medicine;



/**
 * @author RAM
 *
 */
public interface MedicineDao {

	public Medicine addMedicine(Medicine medicine);

	List<Medicine> findByNameContainingIgnoreCase(String medicineName);

	Medicine findByName(String medicineName);

	List<Medicine> findByQuantityGreaterThan(int quantity);

	Long countByDateAdded(String dateAdded);

	public Long getTotalCount();

	public List<Medicine> findTop5ByIdDesc(String date);

	public boolean deleteMedicineById(String id);

	public Medicine getMedicineById(String id);

	public Medicine updateMedicine(Medicine medicine);

	public List<Medicine> getAllMedicine();

}
