package com.jdbcTemplate.jdbc.model.response;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.StudentsGrade;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StudentsGradeGetAllResponse extends BaseResponse{
	List<StudentsGrade> studentsGrades;
}
