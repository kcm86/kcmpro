package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class rowMapper implements RowMapper<model>{

	@Override
	public model mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		model model=new model();
		model.setEmail(rs.getString("email"));
		model.setUsername(rs.getString("username"));
		model.setPassword(rs.getString("password"));
		return model;
	}

}
