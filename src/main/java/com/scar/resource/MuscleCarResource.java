package com.scar.resource;

import com.scar.exceptions.MuscleCarException;
import com.scar.exceptions.ValidateException;
import com.scar.model.MuscleCar;
import com.scar.service.MuscleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/api")
public class MuscleCarResource {

	@Autowired
	private MuscleCarService muscleCarService;

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> listAllCars() {

		try {
			List<Map<String, Object>> result = muscleCarService.listAllCars();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
	public ResponseEntity<MuscleCar> getMuscleCar(@PathVariable("id") int id) {

		try {
			MuscleCar muscleCar = muscleCarService.getCar(id);
			if (muscleCar != null) {
				return ResponseEntity.status(HttpStatus.OK).body(muscleCar);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

		} catch (ValidateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@RequestMapping(value = "/cars/delete/{id}", method = RequestMethod.DELETE)
	public String deleteMuscleCar(@PathVariable("id") int id) {

		try {
			muscleCarService.removeCarFromList(id);
			return  String.valueOf(ResponseEntity.status(HttpStatus.OK));
		} catch (ValidateException e) {
			return String.valueOf(ResponseEntity.status(HttpStatus.BAD_REQUEST));
		}

	}

	@RequestMapping(value = "/cars/add", method = RequestMethod.POST)
	public ResponseEntity<Void> addCarToList( @RequestBody MuscleCar muscleCar) {

		try {
			muscleCarService.addCarToList(muscleCar);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (MuscleCarException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/cars/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCar(@PathVariable("id") int id, @RequestBody MuscleCar muscleCar) {

		try {
			muscleCarService.updateCarFromList(id, muscleCar);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(IllegalStateException e ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
