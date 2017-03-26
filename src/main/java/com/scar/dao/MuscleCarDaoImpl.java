package com.scar.dao;

import javax.sql.DataSource;

import com.scar.model.MuscleCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class MuscleCarDaoImpl extends JdbcDaoSupport implements MuscleCarDao {

	@Autowired
	public MuscleCarDaoImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public MuscleCar getCarFromList(int id) {
		String sql = "select * from muscle_cars where id = ?";
		Object[] args = new Object[] { id };
		return getJdbcTemplate().queryForObject(sql, args, new MuscleCarRowMapper());
	}

	@Override
	public void removeCarFromList(int id) {
		String sql = "delete from muscle_cars where id = ?";
		Object[] args = new Object[] { id };
		getJdbcTemplate().update(sql, args);
	}

    @Override
    public void addCarToList(MuscleCar muscleCar) {
        String sql = "insert into muscle_cars (car_brand, car_model, horsepower, car_engine) values (?, ?, ?, ?)";
        Object[] args = new Object[] {muscleCar.getCarBrand(), muscleCar.getCarModel(), muscleCar.getHorsepower(), muscleCar.getCarEngine()};
        getJdbcTemplate().update(sql, args);
    }

    @Override
    public void updateCarFromList(int id, MuscleCar muscleCar) {
        String sql = "update muscle_cars set car_brand = ?, car_model = ?, horsepower = ?, car_engine = ? where id = ?";
        Object[] args = new Object[] {muscleCar.getCarBrand(), muscleCar.getCarModel(), muscleCar.getHorsepower(), muscleCar.getCarEngine(), id};
        getJdbcTemplate().update(sql, args);
    }

    @Override
    public List<Map<String, Object>> listAllCars() {
        String sql = "select * from muscle_cars";
        return getJdbcTemplate().queryForList(sql);
    }

}
