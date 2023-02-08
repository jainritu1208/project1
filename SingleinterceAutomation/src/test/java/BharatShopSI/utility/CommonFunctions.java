package BharatShopSI.utility;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;


public class CommonFunctions {
	
	
	static utility.Driver.SingletonClassChromeNew singleton = utility.Driver.SingletonClassChromeNew.getInstanceOfSingletonBrowserClass();
	static WebDriver driver = singleton.getDriver();

	private static final String String = null;
	//public static  WebDriver driver;
	static Properties locators;
	static File configFile;
	static FileInputStream fileStream;
	static boolean error=false;
	//boolean error = false;

	int rowcount = 1;
	String sheetName = "S_I Sites";
	HSSFWorkbook wb = new HSSFWorkbook();
	HSSFSheet sheet = wb.createSheet(sheetName);
//	String excelFileName = "C:\\Users\\Deepika\\eclipse-workspace\\websiteData\\src\\main\\java\\websiteDataHeader\\headerData\\Excel\\code.xls";


	public static void loadproperties(String datatype) throws IOException 
	{
//		if(datatype.equals("locators"))
//		{
//			locators=new Properties();
//			configFile= new File("C:\\Users\\Deepika\\eclipse-workspace\\websiteData\\src\\main\\java\\websiteDataHeader\\headerData\\config\\locators.properties");
//			fileStream = new FileInputStream(configFile);
//			locators.load(fileStream);
//		}
	}

	public static String getlocval(String loc) throws IOException {
		loadproperties("locators");
		String path = locators.getProperty(loc);
		return path;

	}
	// this method is to wait first and then click logo , home tab

	public  static WebElement click(By by, WebDriver driver,int wait)
	{
		explicit_wait(driver,by,wait);
		driver.findElement(by).click();
		return null;

	}
	public  static WebElement submit(By by, WebDriver driver,int wait)
	{
		explicit_wait(driver,by,wait);
		driver.findElement(by).submit();
		return null;
	}

	public static void switchTonewTab(By by, WebDriver driver,int wait) throws Exception {
		Actions action= new Actions(driver);
		explicit_wait(driver,by,wait);

		WebElement link = driver.findElement(by);

		action.keyDown(Keys.CONTROL).click(link).build().perform();
		Thread.sleep(3000);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		
	}
	// scroll More
		public static void scroll(WebDriver driver, String direction) {
			if (direction.equals("down")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1500)");
			}
		}
	// scroll less
		public static void scrollless(WebDriver driver, String direction) {
			if (direction.equals("down")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)");
			}
		}
		
		public static void closeAllTab (WebDriver driver)
		{
			String currentTab = driver.getWindowHandle();

			Actions action= new Actions(driver);
			for (String tab : driver.getWindowHandles()) {
				
				if (!tab.equals(currentTab))
				{
					driver.switchTo().window(tab);	
					System.out.println(driver.getCurrentUrl());
					driver.close();
				}
		}driver.switchTo().window(currentTab);
		
				}  

		public static void Textenter (By by, WebDriver driver, int wait)
		{
			explicit_wait(driver,by,wait);

			driver.findElement(by).sendKeys("Delhi");
			
			  				
		
		}

		public static  String Gettext (By by, WebDriver driver, int wait)
		{
			explicit_wait(driver,by,wait);

			String str =  driver.findElement(by).getText();
					return str;				
		}
		
	
			 public static int getResponseCode(String url) throws IOException, InterruptedException {
				
				 //String currenturl = driver.getCurrentUrl();
					URL url1 = new URL(url);
					HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
					connection.setRequestMethod("GET");
					connection.connect();
					int code = connection.getResponseCode();
					System.out.println(code);
					Thread.sleep(3000);
                                     if (code == 200) {
                                    	 System.out.println("pass");
                                    	 }
                                    else
                                       {
                                    	System.out.println("fail");
                                       }
									return code;
			 }
			// this method is for explicit wait
				public static void explicit_wait(WebDriver driver, By by, int wait) {
					WebDriverWait wait2 = new WebDriverWait(driver, wait);
					wait2.until(ExpectedConditions.presenceOfElementLocated(by));
				}

	// this code is to read an excel file..
	public static String[] readXLSXFile() throws IOException {
		System.out.println("a");
		InputStream excelFileName = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\Singleinterface\\BharatShop\\excel\\read.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(excelFileName);

		int sheets = wb.getNumberOfSheets();
		System.out.println(sheets);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator<Row> rows = sheet.rowIterator();

		String[] arrUrls = new String[sheet.getLastRowNum() + 1];
		int rowNum = sheet.getLastRowNum() + 1;
		System.out.println("Total Number of Rows in the excel is : " + rowNum);
		int rowIndex = 0;
		while (rows.hasNext()) {
			row = sheet.getRow(rowIndex);
			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();

				CellType cellType = cell.getCellType().equals(CellType.FORMULA)
						? cell.getCachedFormulaResultType() : cell.getCellType();

				if (cellType.equals(CellType.STRING)) {
					arrUrls[rowIndex] = cell.getStringCellValue();
				} else if(cellType.equals(CellType.NUMERIC)) {
				}
			}
			rowIndex++;
		}
		return arrUrls;
	}
	
	

	
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}
}
