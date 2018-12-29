package com.democompany.demoproject.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.ui.Model;

import java.util.List;

import org.bson.Document;

import com.democompany.demoproject.dao.DemoDAO;
import com.democompany.demoproject.model.Student;

@RestController
@CrossOrigin
@RequestMapping("/RestController")
public class DemoRestController{
	@Autowired
	@Qualifier("demoDAONoSqlImpl")
	DemoDAO demoDAONoSql;
		@RequestMapping(value="/roll/all", method = RequestMethod.GET)
		public List<Document> getAll(){
			return demoDAONoSql.getAll(null);
		}
		@RequestMapping(value="/roll/{roll}", method = RequestMethod.GET)
		public List<Document> getAll(@PathVariable String roll){
			return demoDAONoSql.getAll(roll);
		}
		@RequestMapping(value="/insert", method = RequestMethod.POST)
		public boolean insertOne(@RequestBody Student obj) {
			System.out.println("DemoRestController : " + obj.getRollNo() + obj.getFirstName() + obj.getLastName());
			return demoDAONoSql.dbWrite(obj);
		}
		@RequestMapping(value="/insert/excel", method = RequestMethod.POST)
		public boolean insertMany(@RequestBody Student[] obj) {
			System.out.println("No of records inserted : " + obj.length);
			for(int i = 0; i < obj.length; i++) {
				if(!demoDAONoSql.dbWrite(obj[i]))
					return false;
			}
			return true;
		}
}