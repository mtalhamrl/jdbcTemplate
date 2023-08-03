package com.jdbcTemplate.jdbc.model.response;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.Course;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseGetAllResponse extends BaseResponse {
	List<Course> courses;
	private int page_Number;
	private int total_page;
	private int rowsOfPage;
}
