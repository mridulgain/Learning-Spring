package com.democompany.demoproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Controller;

@Controller
@CrossOrigin
@RequestMapping("/TestAPI")
public class TestRestController{

		@RequestMapping(value="/roll", method = RequestMethod.GET)
		public String getAll(){
			return "TESTshowRecords";
		}
		@RequestMapping(value="/insert", method = RequestMethod.GET)
		public String insertOne() {
			return "TESTinsertOne";
		}
		@RequestMapping(value="/insert/excel", method = RequestMethod.GET)
		public String insertMany() {
			return "TESTinsertMany";
		}
}