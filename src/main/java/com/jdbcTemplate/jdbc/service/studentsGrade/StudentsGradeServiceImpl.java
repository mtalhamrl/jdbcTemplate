package com.jdbcTemplate.jdbc.service.studentsGrade;

import static com.jdbcTemplate.jdbc.model.response.BaseResponse.IS_OK_ITEM;
import static com.jdbcTemplate.jdbc.model.response.BaseResponse.NOT_FOUND_ITEM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcTemplate.jdbc.dao.studentsGrade.StudentsGradeDao;
import com.jdbcTemplate.jdbc.entities.StudentsGrade;
import com.jdbcTemplate.jdbc.model.request.studentsGrade.CreateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.request.studentsGrade.UpdateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeGetByIdResponse;
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
		StudentsGradeGetByIdResponse updateResponse = new StudentsGradeGetByIdResponse();
		StudentsGrade gradeDb = studentsGradeDao.getById(id);
		if(gradeDb==null) {
			updateResponse.setCode(NOT_FOUND_ITEM);
			updateResponse.setOperationMessage("students grades didnt find");
			return updateResponse;
		}
		gradeDb.setGrade(updateStudentsGradeRequest.getGrade());
		int isOk= studentsGradeDao.update(gradeDb);
		if(isOk>0) {
			return this.getById(id);
		}else {
			updateResponse.setCode(NOT_FOUND_ITEM);
			updateResponse.setOperationMessage("there is not any update");
			return updateResponse;
		}
	}

	@Override
	public StudentsGradeGetByIdResponse getById(int id) {
		StudentsGradeGetByIdResponse getByIdResponse = new StudentsGradeGetByIdResponse();
		StudentsGrade gradeDb= studentsGradeDao.getById(id);
		if(gradeDb!=null) {
			getByIdResponse.setCode(IS_OK_ITEM);
			getByIdResponse.setOperationMessage("ok");
			getByIdResponse.setStudentsGrade(gradeDb);
		}else {
			getByIdResponse.setCode(NOT_FOUND_ITEM);
			getByIdResponse.setOperationMessage("the id didnt match");
		}return getByIdResponse;
		
	}

	@Override
	public StudentsGradeDeleteByIdResponse deleteById(int id) {
		
		return null;
	}

}
