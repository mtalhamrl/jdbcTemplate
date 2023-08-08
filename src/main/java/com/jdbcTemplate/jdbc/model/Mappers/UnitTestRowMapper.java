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
		unitTest.setTest_no(rs.getInt("unit"));
		return null;
	}

}
