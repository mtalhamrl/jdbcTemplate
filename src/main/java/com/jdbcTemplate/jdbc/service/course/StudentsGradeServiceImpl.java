package com.jdbcTemplate.jdbc.service.course;

import static com.jdbcTemplate.jdbc.model.response.BaseResponse.IS_OK_ITEM;
import static com.jdbcTemplate.jdbc.model.response.BaseResponse.NOT_FOUND_ITEM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcTemplate.jdbc.dao.course.StudentsGradeDao;
import com.jdbcTemplate.jdbc.entities.StudentsGrade;
import com.jdbcTemplate.jdbc.model.request.CreateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.request.UpdateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.response.StudentsGradeDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.StudentsGradeGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.StudentsGradeGetByIdResponse;
@Service
public class StudentsGradeServiceImpl implements StudentsGradeService{
	@Autowired
	StudentsGradeDao studentsGradeDao;
	
	@Override
	public StudentsGradeGetByIdResponse insert(CreateStudentsGradeRequest createStudentsGradeRequest) {
		StudentsGradeGetByIdResponse insertResponse = new StudentsGradeGetByIdResponse();
		StudentsGrade grade = new StudentsGrade();
		grade.setId(createStudentsGradeRequest.getId());
		grade.setGrade(createStudentsGradeRequest.getGrade());
		int isOk = studentsGradeDao.insert(grade);
		if(isOk>0) {
			return this.getById(createStudentsGradeRequest.getId());
		}else {
		insertResponse.setCode(405);
		insertResponse.setOperationMessage("couldnt save check again");
		return insertResponse;
		}
		
	}

	@Override
	public StudentsGradeGetAllResponse getAll() {
		StudentsGradeGetAllResponse response = new StudentsGradeGetAllResponse(); 
		List<StudentsGrade> grade = studentsGradeDao.getAll();
		if(grade!=null && grade.size()>0) {
		response.setCode(IS_OK_ITEM);
		response.setOperationMessage("ok");
		response.setStudentsGrades(grade);
		}else {
			response.setCode(NOT_FOUND_ITEM);
			response.setOperationMessage("course has not found");
		}
		return response;
		
	}

	@Override
	public StudentsGradeGetByIdResponse update(UpdateStudentsGradeRequest updateStudentsGradeRequest, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentsGradeGetByIdResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentsGradeDeleteByIdResponse deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
