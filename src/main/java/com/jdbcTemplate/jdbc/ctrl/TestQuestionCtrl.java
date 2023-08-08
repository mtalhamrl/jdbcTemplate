package com.jdbcTemplate.jdbc.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcTemplate.jdbc.model.request.unitTest.CreateUnitTestRequest;
import com.jdbcTemplate.jdbc.model.request.unitTest.UpdateUnitTestRequest;
import com.jdbcTemplate.jdbc.model.response.testQuestion.TestQuestionDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.testQuestion.TestQuestionGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.testQuestion.TestQuestionGetByIdResponse;
import com.jdbcTemplate.jdbc.service.testQuestion.TestQuestionService;

@RestController
@RequestMapping("/questions/v1")
public class TestQuestionCtrl {
	@Autowired
	TestQuestionService testQuestionService;
	@GetMapping("/{id}")
	public TestQuestionGetByIdResponse getById(@PathVariable int id) {
		return null;
	}
	@PostMapping("/add")
	ResponseEntity<?> insert(@RequestBody CreateUnitTestRequest createUnitTestRequest){
		return null;
	}
	@GetMapping("/getall")
	public TestQuestionGetAllResponse getAll() {
		return null;
	}
	@PutMapping("/update/{id}")
	ResponseEntity<?> update(@RequestBody UpdateUnitTestRequest unitTestRequest,@PathVariable int id ){
		return null;
	}
	@DeleteMapping("/{id}")
	public TestQuestionDeleteByIdResponse deleteById(@PathVariable int id) {
		return null;
	}
	}

