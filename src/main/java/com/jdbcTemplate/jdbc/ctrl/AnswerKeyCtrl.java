package com.jdbcTemplate.jdbc.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcTemplate.jdbc.model.response.answerkey.AnswerKeyGetAllResponse;
import com.jdbcTemplate.jdbc.service.answerkey.AnswerKeyService;

@RestController
@RequestMapping("/answerkey/v1")
public class AnswerKeyCtrl {
	@Autowired
	AnswerKeyService answerKeyService;
	@GetMapping("/getall")
	public AnswerKeyGetAllResponse getAll() {
		return answerKeyService.getAll();
	}
	
}
