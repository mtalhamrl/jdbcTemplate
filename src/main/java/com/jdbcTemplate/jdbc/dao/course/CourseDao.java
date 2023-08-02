package com.jdbcTemplate.jdbc.dao.course;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.Course;
import com.jdbcTemplate.jdbc.model.request.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.UpdateCourseRequest;

public interface CourseDao {
	int insert(CreateCourseRequest createCourseRequest);
	List<Course> getAll();
	int update(UpdateCourseRequest updateCourseRequest);
}
