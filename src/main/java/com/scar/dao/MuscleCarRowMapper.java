package com.scar.dao;

import com.scar.model.MuscleCar;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MuscleCarRowMapper implements RowMapper<MuscleCar> {

	@Override
	public MuscleCar mapRow(ResultSet rs, int arg1) throws SQLException {
		MuscleCar mc = new MuscleCar();
		mc.setId(rs.getInt("id"));
		mc.setCarBrand(rs.getString("car_brand"));
		mc.setCarModel(rs.getString("car_model"));
		mc.setCarEngine(rs.getString("car_engine"));
		mc.setHorsepower(rs.getInt("horsepower"));
		return mc;
	}

}
