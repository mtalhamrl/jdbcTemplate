package com.jdbcTemplate.jdbc.service.studentsGrade;

import com.jdbcTemplate.jdbc.model.request.studentsGrade.CreateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.request.studentsGrade.UpdateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeGetByIdResponse;

public interface StudentsGradeService {
	StudentsGradeGetByIdResponse insert(CreateStudentsGradeRequest createStudentsGradeRequest);
	public StudentsGradeGetAllResponse getAll();
	StudentsGradeGetByIdResponse update(UpdateStudentsGradeRequest updateStudentsGradeRequest, int id);
	public StudentsGradeGetByIdResponse getById(int id);
	public StudentsGradeDeleteByIdResponse deleteById(int id);
}
