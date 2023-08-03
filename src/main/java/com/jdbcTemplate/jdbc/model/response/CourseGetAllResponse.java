package com.jdbcTemplate.jdbc.model.response;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.Course;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseResponse extends BaseResponse {
	List<Course> courses;
}
