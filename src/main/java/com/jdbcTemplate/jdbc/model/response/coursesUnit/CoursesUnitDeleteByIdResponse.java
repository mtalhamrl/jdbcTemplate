package com.jdbcTemplate.jdbc.model.response.coursesUnit;

import com.jdbcTemplate.jdbc.entities.CoursesUnit;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CoursesUnitDeleteByIdResponse extends BaseResponse{
	CoursesUnit coursesUnit;
}
