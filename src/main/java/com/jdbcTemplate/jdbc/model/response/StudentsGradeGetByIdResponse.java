package com.jdbcTemplate.jdbc.model.response;

import com.jdbcTemplate.jdbc.entities.StudentsGrade;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StudentsGradeGetByIdResponse extends BaseResponse{
		StudentsGrade studentsGrade;
}
