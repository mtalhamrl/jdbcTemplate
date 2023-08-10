package com.jdbcTemplate.jdbc.dao.answerkey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbcTemplate.jdbc.entities.AnswerKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component("AnswerKeyDao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerKeyDaoImpl implements AnswerKeyDao{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<AnswerKey> getAll() {
		String sql="select s.grade_name , c.course_name ,cu.unit,ut.test_no,tq.question_no ,tq.question_answer"
				+ "from studentsgrade s "
				+ "inner join course c on s.id = c.grade_id "
				+ "inner join coursesunit cu on c.id = cu.course_id "
				+ "inner join unit_test ut on cu.id = ut.coursesunit_id "
				+ "inner join test_question tq on ut.id = tq.test_id ";
		return null;
	}
	

}
