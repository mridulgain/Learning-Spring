package com.democompany.demoproject.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.stereotype.Component;

@Component
public abstract class FileDAOImpl implements FileDAO{

	public boolean uploadExcel(CommonsMultipartFile file){
		String path = UPLOAD_DIRECTORY;  
	    String filename = file.getOriginalFilename();
	    String fileExtensionName = filename.substring(filename.indexOf("."));
	    System.out.println(fileExtensionName);
	    if(!fileExtensionName.equals(".xls") && !fileExtensionName.equals(".xlsx"))
	    	return false;
	  
	    System.out.println(path+" "+filename);      
	    try {
	    	byte[] bytes = file.getBytes();  
	    	BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	    			new File(path + File.separator + filename)));  
	    	stream.write(bytes);  
	    	stream.flush();  
	    	stream.close();
	    	return true;
	    }
	    catch(Exception e) {
	    	System.out.println("Upload error");
	    }
    	return false;
	}
	
	public abstract boolean dbWrite(String fileName);
	
	ArrayList<Map<String, Object>> readExcel(String fileName) throws IOException{

		String filePath = UPLOAD_DIRECTORY;
		String sheetName = "Sheet1";
	    File file =    new File(filePath+"/"+fileName);
	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook myWorkbook = null;
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    if(fileExtensionName.equals(".xlsx"))
	    	myWorkbook = new XSSFWorkbook(inputStream);
	    else if(fileExtensionName.equals(".xls"))
	        myWorkbook = new HSSFWorkbook(inputStream);
	    Sheet mySheet = myWorkbook.getSheet(sheetName);
	    int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        //getting row containing col name
        Row row0 = mySheet.getRow(0);
        ArrayList<Map<String, Object>> tempList = new ArrayList<>();
        for(int i = 1; i < rowCount+1; i++) {
        	Row row = mySheet.getRow(i);
        	Map<String, Object> tempMap = new HashMap<>();
        	for(int j = 0; j < row.getLastCellNum(); j++) {
        		String key = dataFormatter.formatCellValue(row0.getCell(j));
        		//Cell value = row.getCell(j);
        		String value = dataFormatter.formatCellValue(row.getCell(j));
        		tempMap.put(key, value);
        	}
        	tempList.add(tempMap);
        }
        return tempList;
	}
}