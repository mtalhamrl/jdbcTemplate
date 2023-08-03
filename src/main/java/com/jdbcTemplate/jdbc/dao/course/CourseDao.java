package com.jdbcTemplate.jdbc.dao.course;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.Course;

public interface CourseDao {
	public int insert(Course createCourseRequest);
	public List<Course> getAll();
	public int update(Course course);
	public Course getById(int id);
	public int deleteById(int id);
}
