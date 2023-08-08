package com.jdbcTemplate.jdbc.service.coursesUnit;

import com.jdbcTemplate.jdbc.model.request.coursesUnit.CreateCoursesUnitRequest;
import com.jdbcTemplate.jdbc.model.request.coursesUnit.UpdateCoursesUnitRequest;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitGetByIdResponse;

public interface CoursesUnitService {
	public CoursesUnitGetByIdResponse insert(CreateCoursesUnitRequest createCoursesUnitRequest);
	public CoursesUnitGetAllResponse getAll();
	public CoursesUnitGetByIdResponse update(UpdateCoursesUnitRequest updateCoursesUnitRequest,int id);
	public CoursesUnitGetByIdResponse getById(int id);
	public CoursesUnitDeleteByIdResponse deleteById(int id);
}
