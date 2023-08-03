package com.jdbcTemplate.jdbc.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcTemplate.jdbc.model.request.CreateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.response.StudentsGradeGetAllResponse;
import com.jdbcTemplate.jdbc.service.course.StudentsGradeService;

@RestController
@RequestMapping("/grades/v1")

public class StudentsGradeCtrl {
	@Autowired
	StudentsGradeService studentsGradeService;
	@PostMapping("/add")
	ResponseEntity<?> insert(@RequestBody CreateStudentsGradeRequest createStudentsGradeRequest) {
	return ResponseEntity.ok(studentsGradeService.insert(createStudentsGradeRequest));
}
	@GetMapping("/getall")
	public StudentsGradeGetAllResponse getAll() {
		return studentsGradeService.getAll();
	}
}