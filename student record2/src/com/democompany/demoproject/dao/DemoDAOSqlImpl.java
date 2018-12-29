package com.democompany.demoproject.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import org.bson.Document;
import java.util.List;

import com.democompany.demoproject.model.Student;
@Component
public class DemoDAOSqlImpl implements DemoDAO{
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}
	public boolean dbWrite(Student stud) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "Insert into testTable2 values(?, ?, ?)";
		Object[] args = new Object[] {stud.getRollNo(), stud.getFirstName(), stud.getLastName()};

			int status = jdbcTemplate.update(query, args);
			if(status != 0)
				return true;
			else
				return false;
	}
	public List<Document> getAll(String roll) {
		
		return null;
	}
	
}