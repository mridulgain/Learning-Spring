import java.io.IOException;
public class FileReaderMain{
	public static void main(String args[])throws IOException{
		FileReader testExcelFile = new FileReader();
		String testFilePath = "/home/rohan/eclipse-workspace/csv reader/";
		String testFileName = "student_record.xlsx";
		String testExcelSheetName = "Sheet1";
		testExcelFile.readExcel(testFilePath, testFileName, testExcelSheetName);
		System.out.println(testExcelFile.readExcel2(testFilePath, testFileName, testExcelSheetName));
	}
}