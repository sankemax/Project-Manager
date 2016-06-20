package com.max.project.manager.utils;

import java.util.Arrays;

import org.springframework.jdbc.core.namedparam.AbstractSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class ParamSourceUtil {

	public class CombinedSqlParameterSource extends AbstractSqlParameterSource {

		SqlParameterSource param;
		SqlParameterSource[] params;
		
		public CombinedSqlParameterSource(SqlParameterSource param, SqlParameterSource[] params) {
			this.param = param;
			this.params = params;
		}
		
		@Override
		public boolean hasValue(String paramName) {
			return param.hasValue(paramName) || Arrays.asList(params)
												.stream()
												.anyMatch((param) -> {
													return param.hasValue(paramName);});
		}

		@Override
		public Object getValue(String paramName) throws IllegalArgumentException {
			return param.hasValue(paramName) ?
					param.getValue(paramName) : 
				Arrays.asList(params)
				.stream()
				.filter((param) -> {
					return param.hasValue(paramName);})
				.findFirst().get();
		}
		
	}
}
