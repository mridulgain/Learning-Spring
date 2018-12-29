import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.HashMap;
import java.util.ArrayList;

public class FileReader{
	   public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

		    //Create an object of File class to open xlsx file

		    File file =    new File(filePath+"/"+fileName);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook myWorkbook = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    myWorkbook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of XSSFWorkbook class

		        myWorkbook = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    Sheet mySheet = myWorkbook.getSheet(sheetName);

		    //Find number of rows in excel file

		    int rowCount = mySheet.getLastRowNum()-mySheet.getFirstRowNum();
		    
	        // Create a DataFormatter to format and get each cell's value as String
	        DataFormatter dataFormatter = new DataFormatter();

		    //Create a loop over all the rows of excel file to read it

		    for (int i = 0; i < rowCount+1; i++) {

		        Row row = mySheet.getRow(i);

		        //Create a loop to print cell values in a row

		        for (int j = 0; j < row.getLastCellNum(); j++) {

		            //Print Excel data in console

		            //String cellValue = row.getCell(j).getStringCellValue();
		        	String cellValue = dataFormatter.formatCellValue(row.getCell(j));
		        	System.out.print(cellValue + "|| ");
		        }
		        System.out.println();
		    }
      }
	  public ArrayList<HashMap<String, Object>> readExcel2(String filePath,String fileName,String sheetName) throws IOException{

		    //Create an object of File class to open xlsx file

		    File file =    new File(filePath+"/"+fileName);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook myWorkbook = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    myWorkbook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of XSSFWorkbook class

		        myWorkbook = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    Sheet mySheet = myWorkbook.getSheet(sheetName);

		    //Find number of rows in excel file

		    int rowCount = mySheet.getLastRowNum()-mySheet.getFirstRowNum();
		    
	        // Create a DataFormatter to format and get each cell's value as String
	        DataFormatter dataFormatter = new DataFormatter();

		    //Create a loop over all the rows of excel file to read it

	        Row row0 = mySheet.getRow(0);
	        ArrayList<HashMap<String, Object>> tempList = new ArrayList<>();
	        for(int i = 1; i < rowCount+1; i++) {
	        	Row row = mySheet.getRow(i);
	        	HashMap<String, Object> tempMap = new HashMap<>();
	        	for(int j = 0; j < row.getLastCellNum(); j++) {
	        		String key = dataFormatter.formatCellValue(row0.getCell(j));
	        		Cell value = row.getCell(j);
	        		tempMap.put(key, value);
	        	}
	        	tempList.add(tempMap);
	        	System.out.println(tempMap);
	        }
	        return tempList;
     }
}