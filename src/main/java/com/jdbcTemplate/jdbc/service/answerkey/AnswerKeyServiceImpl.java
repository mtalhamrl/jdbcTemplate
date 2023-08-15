package com.jdbcTemplate.jdbc.service.answerkey;

import static com.jdbcTemplate.jdbc.model.response.BaseResponse.IS_OK_ITEM;
import static com.jdbcTemplate.jdbc.model.response.BaseResponse.NOT_FOUND_ITEM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcTemplate.jdbc.dao.answerkey.AnswerKeyDao;
import com.jdbcTemplate.jdbc.entities.AnswerKey;
import com.jdbcTemplate.jdbc.model.response.answerkey.AnswerKeyGetAllResponse;
@Service
public class AnswerKeyServiceImpl implements AnswerKeyService{
	@Autowired
	AnswerKeyDao answerKeyDao;
	@Override
	
	public AnswerKeyGetAllResponse getAll() {
		
		AnswerKeyGetAllResponse response = new AnswerKeyGetAllResponse();
		List<AnswerKey> answerKey = answerKeyDao.getAll();
		if(answerKey!=null && answerKey.size()>0) {
			response.setCode(IS_OK_ITEM);
			response.setOperationMessage("ok");
			response.setAnswerKeys(answerKey);	
			}else {
				response.setCode(NOT_FOUND_ITEM);
				response.setOperationMessage("answerkeys has not found");
			}
			return response;		
	}			
}
