package com.jdbcTemplate.jdbc.model.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbcTemplate.jdbc.entities.UnitTest;

public class UnitTestRowMapper implements RowMapper<UnitTest>{

	@Override
	public UnitTest mapRow(ResultSet rs, int rowNum) throws SQLException {
		UnitTest unitTest = new UnitTest();
		unitTest.setId(rs.getInt("id"));
		unitTest.setTest_no(rs.getString("test_no"));
		unitTest.setCoursesunit_id(rs.getInt("coursesunit_id"));
		return unitTest;
	}

}
