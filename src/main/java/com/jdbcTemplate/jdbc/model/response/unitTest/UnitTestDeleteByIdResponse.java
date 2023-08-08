package com.jdbcTemplate.jdbc.model.response.unitTest;

import com.jdbcTemplate.jdbc.entities.UnitTest;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UnitTestDeleteByIdResponse extends BaseResponse{
	UnitTest unitTest;

}
