package com.jdbcTemplate.jdbc.service.testQuestion;

import static com.jdbcTemplate.jdbc.model.response.BaseResponse.IS_OK_ITEM;
import static com.jdbcTemplate.jdbc.model.response.BaseResponse.NOT_FOUND_ITEM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcTemplate.jdbc.dao.testQuestion.TestQuestionDao;
import com.jdbcTemplate.jdbc.entities.TestQuestion;
import com.jdbcTemplate.jdbc.model.request.testQuestion.CreateTestQuestionRequest;
import com.jdbcTemplate.jdbc.model.request.testQuestion.UpdateTestQuestionRequest;
import com.jdbcTemplate.jdbc.model.response.testQuestion.TestQuestionGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.testQuestion.TestQuestionGetByIdResponse;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestDeleteByIdResponse;
@Service
public class TestQuestionServiceImpl implements TestQuestionService{
	@Autowired
	TestQuestionDao testQuestionDao;
	@Override
	public TestQuestionGetByIdResponse getById(int id) {
		TestQuestionGetByIdResponse getByIdResponse = new TestQuestionGetByIdResponse();
		TestQuestion testQuestion = testQuestionDao.getById(id);
		if(testQuestion!=null) {
			getByIdResponse.setCode(IS_OK_ITEM);
			getByIdResponse.setOperationMessage("ok");
			getByIdResponse.setTestQuestion(testQuestion);
		}else {
			getByIdResponse.setCode(NOT_FOUND_ITEM);
			getByIdResponse.setOperationMessage("the id didnt match");
		}return getByIdResponse;
		}
		
	@Override
	public TestQuestionGetByIdResponse insert(CreateTestQuestionRequest createTestQuestionRequest) {
		TestQuestionGetByIdResponse insertResponse = new TestQuestionGetByIdResponse();
		TestQuestion testQuestion = new TestQuestion();
		testQuestion.setId(createTestQuestionRequest.getId());
		testQuestion.setQuestion_no(createTestQuestionRequest.getQuestion_no());
		testQuestion.setQuestion_answer(createTestQuestionRequest.getQuestion_answer());
		int isOk= testQuestionDao.insert(testQuestion);
		if(isOk>0) {
			return this.getById(createTestQuestionRequest.getId());
		}else {
			insertResponse.setCode(405);
			insertResponse.setOperationMessage("couldnt save check again");
			return insertResponse;
			}
		
	}

	@Override
	public TestQuestionGetAllResponse getAll() {
		TestQuestionGetAllResponse response =new TestQuestionGetAllResponse();
		List<TestQuestion> testQuestions = testQuestionDao.getAll();
		if(testQuestions!=null && testQuestions.size()>0) {
			response.setCode(IS_OK_ITEM);
			response.setOperationMessage("ok");
			response.setTestQuestions(testQuestions);
			}else {
				response.setCode(NOT_FOUND_ITEM);
				response.setOperationMessage("course has not found");
			}
			return response;
		
	}

	@Override
	public TestQuestionGetByIdResponse update(UpdateTestQuestionRequest updateTestQuestionRequest, int id) {
		
		return null;
	}

	@Override
	public UnitTestDeleteByIdResponse deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}