package com.jdbcTemplate.jdbc.service.course;

import com.jdbcTemplate.jdbc.model.request.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.UpdateCourseRequest;
import com.jdbcTemplate.jdbc.model.response.CourseDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.CourseGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.CourseGetByIdResponse;


public interface CourseService {
	
	CourseGetByIdResponse insert(CreateCourseRequest createCourseRequest);
	public CourseGetAllResponse getAll();
	CourseGetByIdResponse update(UpdateCourseRequest updateCourseRequest, int id);
	public CourseGetByIdResponse getById(int id);
	public CourseDeleteByIdResponse deleteById(int id);

}
