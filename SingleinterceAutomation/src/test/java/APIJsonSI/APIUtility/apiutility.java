package APIJsonSI.APIUtility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class apiutility 
{
        public static int a=0;
	static int rowcount = 1;
	static String sheetName = "Header Footer API";
	static HSSFWorkbook wb = new HSSFWorkbook();
	static HSSFSheet sheet = wb.createSheet(sheetName);
	static String writecode = System.getProperty("user.dir")+"\\src\\test\\java\\APIJsonSI\\APIUtility\\writeapiurl.xls";

	// code is to write url value in excel sheet..
	public static void failcode(String Url, String status ) throws IOException {
		HSSFRow row = sheet.createRow(rowcount);
		// iterating c number of columns
		int cellUrl = 0;
		HSSFCell cellurl = row.createCell(cellUrl);
		cellurl.setCellValue(Url);
		int cellUrlone = 1;
		HSSFCell cellurlone = row.createCell(cellUrlone);
		cellurlone.setCellValue(status);
		FileOutputStream fileOut1 = new FileOutputStream(writecode);
		wb.write(fileOut1);
		rowcount++;
                a++;
	}


	public static void Passcode(String Url, String status) throws IOException {
		HSSFRow row = sheet.createRow(rowcount);
		// iterating c number of columns
		int cellUrl = 0;
		HSSFCell cellurl = row.createCell(cellUrl);
		cellurl.setCellValue(Url);
		int cellUrlone = 1;
		HSSFCell cellurlone = row.createCell(cellUrlone);
		cellurlone.setCellValue(status);
		int cellUrltwo = 2;
		FileOutputStream fileOut1 = new FileOutputStream(writecode);
		wb.write(fileOut1);
		rowcount++;
	}

	// This code is to write a row header values...
	public static void headerValues() throws IOException {
		System.out.println("*************************************");
		int newrow = 0;
		HSSFRow row1 = sheet.createRow(newrow);

		ArrayList<String> names = new ArrayList<String>(Arrays.asList("Link Urls", "Status"));
		int c = 0;
		for (String cellName : names) {
			HSSFCell cell = row1.createCell(c++);
			cell.setCellValue(cellName);
		}
		FileOutputStream fileOut3 = new FileOutputStream(writecode);
		wb.write(fileOut3);
	}


}