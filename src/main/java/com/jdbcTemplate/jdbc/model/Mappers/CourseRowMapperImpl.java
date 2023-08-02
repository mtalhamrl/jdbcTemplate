package com.jdbcTemplate.jdbc.model.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbcTemplate.jdbc.entities.Course;

public class CourseRowMapperImpl implements org.springframework.jdbc.core.RowMapper<Course>{
	

	@Override
	 public Course mapRow(ResultSet rs, int rowNum) throws SQLException {  
			Course course = new Course();  
			course.setId(rs.getInt("id"));
			course.setName(rs.getString("name"));
		  return course; 
		 }  
	}

