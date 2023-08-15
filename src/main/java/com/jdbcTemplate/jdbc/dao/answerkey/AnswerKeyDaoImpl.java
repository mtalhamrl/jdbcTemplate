package com.jdbcTemplate.jdbc.dao.answerkey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		String sql="select s.grade_name , c.course_name ,cu.unit,ut.id,ut.test_no,tq.question_no ,tq.question_answer "
				+ "from studentsgrade s "
				+ "inner join course c on s.id = c.grade_id "
				+ "inner join coursesunit cu on c.id = cu.course_id "
				+ "inner join unit_test ut on cu.id = ut.coursesunit_id "
				+ "inner join test_question tq on ut.id = tq.test_id ";
		
				
		return jdbcTemplate.query(
	                sql,rs -> { //lambda operations
	                    Map<String, AnswerKey> answerKeyMap = new LinkedHashMap<>();	                
	                    while (rs.next()) {
	                String testNo =	rs.getString("id"); //id= unit_test table primary key.
                	AnswerKey answer= answerKeyMap.getOrDefault(testNo, new AnswerKey(
                			rs.getString("grade_name"),
                			rs.getString("course_name"),
                			rs.getString("unit"),
                			rs.getString("test_no"),
                			new HashMap<String, String>()
                			));
                	answer.getAnswerMap().put(rs.getString("question_no"),rs.getString("question_answer"));
                	answerKeyMap.put(testNo,answer);
	                    }
                	return new ArrayList<AnswerKey>(answerKeyMap.values());
	                    }                            
	                );
				}
			}
