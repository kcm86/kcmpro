package com.example.demo;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class registrasi implements regisInterface{
	  
	  private static JdbcTemplate template;
      
	  @Autowired
	  public registrasi(DataSource dataSource) {
		  template = new JdbcTemplate(dataSource);
	  }  
	  
	  @Override
	  public int save(model modell) {
		System.out.println("Registrasi : "+modell.getEmail()+" "+modell.getUsername()+" "+modell.getPassword());
	    return template.update("INSERT INTO account VALUES(?,?,?)",
	        new Object[] { modell.getEmail(), modell.getUsername(), modell.getPassword()});
	  }
	 
	
	  @Override
	  public model login(model modell) {
		    return template.queryForObject("SELECT * FROM account WHERE email = ? AND password = ?",
		        new rowMapper(), new Object[] { modell.getEmail(),  modell.getPassword()} );
	  }

}
