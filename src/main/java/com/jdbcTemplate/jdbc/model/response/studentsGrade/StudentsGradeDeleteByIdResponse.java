package com.jdbcTemplate.jdbc.model.response.studentsGrade;

import com.jdbcTemplate.jdbc.entities.StudentsGrade;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StudentsGradeDeleteByIdResponse extends BaseResponse{
	StudentsGrade studentsGrade;
}
