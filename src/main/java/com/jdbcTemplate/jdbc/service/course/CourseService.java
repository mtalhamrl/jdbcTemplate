package com.jdbcTemplate.jdbc.service.course;

import com.jdbcTemplate.jdbc.model.request.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.UpdateCourseRequest;
import com.jdbcTemplate.jdbc.model.response.CourseResponse;


public interface CourseService {
	
	boolean insert(CreateCourseRequest createCourseRequest);
	public CourseResponse getAll();
	boolean update(UpdateCourseRequest updateCourseRequest);
	
}
