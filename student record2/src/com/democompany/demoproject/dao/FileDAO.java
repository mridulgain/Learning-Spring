package com.democompany.demoproject.dao;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FileDAO {
	public static final String UPLOAD_DIRECTORY = System.getProperty("catalina.home") + "/temp";
	boolean uploadExcel(CommonsMultipartFile file);
	boolean dbWrite(String fileName);
}