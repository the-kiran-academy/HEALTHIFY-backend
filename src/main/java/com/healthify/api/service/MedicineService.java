package com.healthify.api.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.healthify.api.entity.Medicine;

/**
 * @author RAM
 *
 */
@Transactional
public interface MedicineService {
	Medicine addMedicine(Medicine medicine);
	boolean deleteMedicineById(String id);
	Medicine getMedicineById(String id);
	Medicine updateMedicine(Medicine medicine);
	List<Medicine> getAllMedicine();
	List<Medicine> getMedicinesByName(String medicineName);
	Medicine getMedicineByName(String medicineName);
	List<Medicine> getMedicinesWithQuantityMoreThanZero(int quantity);
	Long getCountOfMedicineByDateAdded(String dateAdded);
    Long getMedicinesTotalCount();
    List<Medicine> getTop5MedicineAddedByDate(String date);
}
