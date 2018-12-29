package com.democompany.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.multipart.commons.CommonsMultipartFile;  
import org.springframework.beans.factory.annotation.Qualifier;

import com.democompany.demoproject.model.Student;
import com.democompany.demoproject.dao.DemoDAO;
import com.democompany.demoproject.dao.FileDAO;

@Controller
@RequestMapping("/DemoController")
public class DemoController{
	
	@Autowired
	@Qualifier("demoDAOSqlImpl")
	DemoDAO demoDAO;
	@Autowired
	@Qualifier("demoDAONoSqlImpl")
	DemoDAO demoDAONoSql; 
	@Autowired
	FileDAO fileDAO;
	
	@RequestMapping(value="/insertdata", method = RequestMethod.GET)
	public String insertData(Model m) {
		System.out.println("Server : form requested by client");
		Student stud = new Student();
		m.addAttribute("student", stud);
		return "form";
	}
	
	@RequestMapping(value="/dosomething", method = RequestMethod.POST)
	public ModelAndView doSomething(@ModelAttribute("student") Student stud, @RequestParam String dbSelection) {
		System.out.println("Server : Values received from client");
		System.out.println(stud.getRollNo());
		System.out.println(stud.getFirstName());
		System.out.println(stud.getLastName());
		System.out.println("dbSelection");
		
		return new ModelAndView("status", "message", "Done something");
	}	
	
	@RequestMapping(value="/saveDataBySql", method = RequestMethod.POST)
	public ModelAndView saveDataSql(@ModelAttribute("student") Student stud) {
		String message = "";
		if(demoDAO!=null && demoDAO.dbWrite(stud)) {
			System.out.println("Server : db write successful");
			message = "Server : db write successful";
		}
		else
			System.out.println("Server : db write unsuccessful");
			message = "Server : db write unsuccessful";
		return new ModelAndView("status", "message", message);
	}
	@RequestMapping(value="/saveDataByNoSql", method = RequestMethod.POST)
	public ModelAndView saveDataNoSql(@ModelAttribute("student") Student stud) {
		String message = "";
		if(demoDAONoSql!=null && demoDAONoSql.dbWrite(stud)) {
			message = "Server : mongodb write successful";
			System.out.println("Server : mongodb write successful");
		}
		else {
			message = "Server : mongodb write unsuccessful";
			System.out.println("Server : mongodb write unsuccessful");
		}
		return new ModelAndView("status", "message", message);
	}
	/*-------------------------------------------------------------------*/
	@RequestMapping(value="/uploaddata", method = RequestMethod.GET)
	public String uploadData() {
		return "uploadform";
	}
    @RequestMapping(value="savefile",method=RequestMethod.POST)  
    public ModelAndView savefile( @RequestParam CommonsMultipartFile file){
    	String message="";
    	if(fileDAO.uploadExcel(file)) {
    		String filename = file.getOriginalFilename();
    		if(!fileDAO.dbWrite(filename))
    			message = "DB write failure";
    		else
    			message = "ok";
    	}
    	else {
    		message = "File Upload failed";
    	}
    	return new ModelAndView("status", "message", message);  
    }	
}