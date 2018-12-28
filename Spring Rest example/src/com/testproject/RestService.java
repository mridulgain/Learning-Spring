package com.testproject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.bson.Document;
@RestController
@RequestMapping("/rest")
public class RestService{
	@Autowired
	RestDAO restDAO;
	public void setRestDAO(RestDAO r) {
		this.restDAO = r;
	}
	@RequestMapping(value="/getresource", method=RequestMethod.GET)
	public RestResource getResource(@RequestParam int id) {
		RestResource tempResource = restDAO.retriveResource(id);
		return tempResource;
	}
	@RequestMapping(value="/id/{id}", method=RequestMethod.GET)
	public RestResource getResource2(@PathVariable int id) {
		RestResource tempResource = restDAO.retriveResource(id);
		return tempResource;
	}
	@RequestMapping(value="/getresource/{id}", method=RequestMethod.GET)
	public List<RestResource> getResources(@PathVariable int id) {
		List<RestResource> tempList = new ArrayList<RestResource>();
		RestResource tempResource = restDAO.retriveResource(id);
		tempList.add(tempResource);
		tempList.add(restDAO.retriveResource(id+1));
		return tempList;
	}
	@RequestMapping(value="/getdoc/{id}", method=RequestMethod.GET)
	public Document getDocument(@PathVariable int id) {
		Document tempDocument = new Document("id",3);
		tempDocument.put("name", "Static name");
		return tempDocument;
	}
}