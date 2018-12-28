package com.testproject;
import org.springframework.stereotype.Component; 
@Component
public class RestDAO{
	public RestResource retriveResource(int id) {
		RestResource tempResource = new RestResource();
		tempResource.setId(id);
		tempResource.setName("Retrieved_Name");
		return tempResource; 
	}
}