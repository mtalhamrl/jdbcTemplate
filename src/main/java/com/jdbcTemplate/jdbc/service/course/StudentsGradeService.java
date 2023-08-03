package com.jdbcTemplate.jdbc.service.course;

import com.jdbcTemplate.jdbc.model.request.CreateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.request.UpdateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.response.StudentsGradeDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.StudentsGradeGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.StudentsGradeGetByIdResponse;

public interface StudentsGradeService {
	CreateStudentsGradeRequest insert(CreateStudentsGradeRequest createStudentsGradeRequest);
	public StudentsGradeGetAllResponse getAll();
	StudentsGradeGetByIdResponse update(UpdateStudentsGradeRequest updateStudentsGradeRequest, int id);
	public StudentsGradeGetByIdResponse getById(int id);
	public StudentsGradeDeleteByIdResponse deleteById(int id);
}
