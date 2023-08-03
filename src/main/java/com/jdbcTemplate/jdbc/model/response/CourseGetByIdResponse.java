package com.jdbcTemplate.jdbc.model.response;

import com.jdbcTemplate.jdbc.entities.Course;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseGetByIdResponse extends BaseResponse{
	Course course;
}
