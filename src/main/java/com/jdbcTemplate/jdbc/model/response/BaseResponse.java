package com.jdbcTemplate.jdbc.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
	public static final int NOT_FOUND_ITEM=404;
	public static final int IS_OK_ITEM=200;

	private int code;
	private String operationMessage;
	
	
}
