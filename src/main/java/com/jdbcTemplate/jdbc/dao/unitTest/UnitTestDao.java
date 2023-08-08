package com.jdbcTemplate.jdbc.dao.unitTest;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.UnitTest;

public interface UnitTestDao {
	public int insert(UnitTest unitTest);
	public List<UnitTest> getAll();
	public int update(UnitTest unitTest);
	public UnitTest getById(int id);
	public int deleteById(int id);
}
