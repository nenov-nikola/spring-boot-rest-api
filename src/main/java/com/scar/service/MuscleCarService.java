package com.scar.service;

import com.scar.dao.MuscleCarDao;
import com.scar.exceptions.MuscleCarException;
import com.scar.exceptions.ValidateException;
import com.scar.model.MuscleCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MuscleCarService {

	@Autowired
	private MuscleCarDao muscleCarDao;

	public MuscleCar getCar(int id) throws ValidateException {
		if (id <= 0) {
			throw new ValidateException("ID can not be 0 or <0");
		}
		return muscleCarDao.getCarFromList(id);
	}

	public void removeCarFromList(int id) throws ValidateException {
		if (id <= 0) {
			throw new ValidateException("ID can not be 0 or < 0 or this id do not exist");
		}
		 muscleCarDao.removeCarFromList(id);
	}

	public List<Map<String, Object>> listAllCars() {

		List<Map<String, Object>> result = muscleCarDao.listAllCars();
			if (!result.isEmpty()) {
				return result;
			} else {
				return null;
			}
	}

	public void addCarToList(MuscleCar muscleCar) throws MuscleCarException {
		if (muscleCar == null) {
			throw new MuscleCarException("The passed object can not be null.");
		}
		muscleCarDao.addCarToList(muscleCar);
	}

	public void updateCarFromList(int id, MuscleCar muscleCar) {
		if ( id <= 0 && muscleCar == null) {
			throw new IllegalArgumentException("The passed object can not be null.");
		}
		muscleCarDao.updateCarFromList(id, muscleCar);
	}

}
