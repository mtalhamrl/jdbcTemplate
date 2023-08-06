package com.jdbcTemplate.jdbc.model.response.course;

import com.jdbcTemplate.jdbc.entities.Course;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseGetByIdResponse extends BaseResponse{
	Course course;
}
