package com.jdbcTemplate.jdbc.service.course;

import com.jdbcTemplate.jdbc.model.request.course.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.course.UpdateCourseRequest;
import com.jdbcTemplate.jdbc.model.response.course.CourseDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.course.CourseGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.course.CourseGetByIdResponse;


public interface CourseService {
	
	CourseGetByIdResponse insert(CreateCourseRequest createCourseRequest);
	public CourseGetAllResponse getAll();
	CourseGetByIdResponse update(UpdateCourseRequest updateCourseRequest, int id);
	public CourseGetByIdResponse getById(int id);
	public CourseDeleteByIdResponse deleteById(int id);

}
