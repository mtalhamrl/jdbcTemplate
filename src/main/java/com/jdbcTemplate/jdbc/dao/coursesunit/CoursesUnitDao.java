package com.jdbcTemplate.jdbc.dao.coursesunit;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.CoursesUnit;

public interface CoursesUnitDao {
	public int insert(CoursesUnit coursesUnit );
	public List<CoursesUnit> getAll();
	public int update(CoursesUnit coursesUnit);
	public CoursesUnit getById(int id);
	public int deleteById(int id);
}
