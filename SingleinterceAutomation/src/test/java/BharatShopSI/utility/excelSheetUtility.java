package BharatShopSI.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

public class excelSheetUtility {

	static int rowcount = 1;
	static String sheetName = "Bharat.Shop urls";
	static HSSFWorkbook wb = new HSSFWorkbook();
	static HSSFSheet sheet = wb.createSheet(sheetName);
	static String excelFileName = "Bharatwritesheet.xls";
//			System.getProperty("user.dir")+"\\src\\main\\java\\Singleinterface\\BharatShop\\excel\\write.xls";

	// code is to write url value in excel sheet..
		public static void failcode(String urls, int HTMLCode, String Status) throws IOException {
			HSSFRow row = sheet.createRow(rowcount);
			// iterating c number of columns
			int cellUrl = 0;
			HSSFCell cellurl = row.createCell(cellUrl);
			cellurl.setCellValue(urls);
			int cellUrlone = 1;
			HSSFCell cellurlone = row.createCell(cellUrlone);
			cellurlone.setCellValue(HTMLCode);
			int cellUrltwo = 2;
			HSSFCell cellUrlt = row.createCell(cellUrltwo);
			cellUrlt.setCellValue(Status);
			FileOutputStream fileOut1 = new FileOutputStream(excelFileName);
			wb.write(fileOut1);
			rowcount++;
		}

		// code to write book a test drive..
		public static void Passcode(String urls, int HTMLCode, String Status) throws IOException {
			HSSFRow row = sheet.createRow(rowcount);
			// iterating c number of columns
			int cellUrl = 0;
			HSSFCell cellurl = row.createCell(cellUrl);
			cellurl.setCellValue(urls);
			int cellUrlone = 1;
			HSSFCell cellurlone = row.createCell(cellUrlone);
			cellurlone.setCellValue(HTMLCode);
			int cellUrltwo = 2;
			HSSFCell cellUrlt = row.createCell(cellUrltwo);
			cellUrlt.setCellValue(Status);
			FileOutputStream fileOut1 = new FileOutputStream(excelFileName);
			wb.write(fileOut1);
			rowcount++;
		}

		// This code is to write a row header values...
		public static void headerValues() throws IOException {
			int newrow = 0;
			HSSFRow row1 = sheet.createRow(newrow);

			ArrayList<String> names = new ArrayList<String>(Arrays.asList("urls", "HTML Page Code", "Status"));
			int c = 0;
			for (String cellName : names) {
				HSSFCell cell = row1.createCell(c++);
				cell.setCellValue(cellName);
			}
			FileOutputStream fileOut3 = new FileOutputStream(excelFileName);
			wb.write(fileOut3);
		}

		
	}
