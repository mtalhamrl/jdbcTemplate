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

import com.jdbcTemplate.jdbc.model.request.studentsGrade.CreateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.request.studentsGrade.UpdateStudentsGradeRequest;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.studentsGrade.StudentsGradeGetByIdResponse;
import com.jdbcTemplate.jdbc.service.studentsGrade.StudentsGradeService;

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
	
	@PutMapping("/update/{id}")
	ResponseEntity<?> update(@RequestBody UpdateStudentsGradeRequest gradeRequest , @PathVariable int id){		
		return ResponseEntity.ok(studentsGradeService.update(gradeRequest, id));
	}
	@GetMapping("/{id}")
	public StudentsGradeGetByIdResponse getByIdResponse(@PathVariable int id) {
		return studentsGradeService.getById(id);
	}
	@DeleteMapping("/{id}")
	StudentsGradeDeleteByIdResponse deleteByIdResponse (@PathVariable int id) {
		return this.studentsGradeService.deleteById(id);
	}
	
}