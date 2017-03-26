package com.scar.dao;


import com.scar.model.MuscleCar;

import java.util.List;
import java.util.Map;

public interface MuscleCarDao {

	MuscleCar getCarFromList(int id);
	
	void removeCarFromList(int id);

	void addCarToList(MuscleCar muscleCar);

	void updateCarFromList(int id, MuscleCar muscleCar);

	List<Map<String, Object>> listAllCars();

}
