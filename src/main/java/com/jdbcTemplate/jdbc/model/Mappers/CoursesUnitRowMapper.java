package com.jdbcTemplate.jdbc.model.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbcTemplate.jdbc.entities.CoursesUnit;

public class CoursesUnitRowMapper implements RowMapper<CoursesUnit>{

	@Override
	public CoursesUnit mapRow(ResultSet rs, int rowNum) throws SQLException {
		CoursesUnit coursesUnit = new CoursesUnit();
		coursesUnit.setId(rs.getInt("id"));
		coursesUnit.setUnit(rs.getString("unit"));
		coursesUnit.setTest_id(rs.getInt("test_id"));

		return coursesUnit;
	}

}
