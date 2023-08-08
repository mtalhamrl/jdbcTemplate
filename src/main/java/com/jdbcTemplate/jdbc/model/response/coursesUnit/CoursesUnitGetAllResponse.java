package com.jdbcTemplate.jdbc.model.response.coursesUnit;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.CoursesUnit;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CoursesUnitGetAllResponse extends BaseResponse{
	List<CoursesUnit> coursesUnits;
}
