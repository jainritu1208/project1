package APIJsonSI.repository;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import APIJsonSI.APIUtility.apiutility;
import APIJsonSI.APIUtility.sendmail;



public class combine extends apiutility {

	static utility.Driver.SingletonClassChromeNew singleton = utility.Driver.SingletonClassChromeNew.getInstanceOfSingletonBrowserClass();
	static WebDriver driver = singleton.getDriver();
	
	static boolean error=false;
	public combine() throws IOException {
		apiutility.headerValues();
		driver.manage().window().maximize();

	}

	@Test(dataProvider= "dataprov")
	public static void footercheck(String urls) throws InterruptedException, ParseException, IOException, ClassNotFoundException
	{
		try {
			error=false;

			driver.get(urls);
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(1000);
			if (driver.getCurrentUrl().startsWith("https://dealers.skoda-auto.co.in"))
			{
				Thread.sleep(2000);

				System.out.println("Header and footer API for "+ driver.getTitle());

				//Checking Header API for skoda
				if(driver.findElements(By.cssSelector("div.header-menu a")).size()>0)     //Skoda Header
				{
					String data=driver.findElement(By.cssSelector("div.header-menu a")).getAttribute("href");
					System.out.println(data);
					System.out.println("Skoda Header API is present");

				}
				else
				{
					System.out.println("Header API is not present");
					error=true;


				}	
			}
			// Hero Header

			if (driver.getCurrentUrl().startsWith("https://dealers.heromotocorp.com/"))
			{
				Thread.sleep(2000);

				System.out.println("Header and footer API for "+ driver.getTitle());

				//Checking Header API for Hero
				if(driver.findElements(By.cssSelector(".header-main a")).size()>0)     //Hero Header
				{
					String data=driver.findElement(By.cssSelector(".header-main a")).getAttribute("href");
					System.out.println(data);
					System.out.println("Hero Header API is present");

				}
				else
				{
					System.out.println("HERO Header API is not present");
					error=true;
				}	
			}

			Thread.sleep(2000);
			if(driver.findElements(By.cssSelector("div.footer-links a")).size()>0)  //Skoda footer API
			{
				driver.findElement(By.cssSelector("div.footer-links a")).getAttribute("href");
				System.out.println("Skoda Footer API is present");

			}
			else if(driver.findElements(By.cssSelector("div.footerlinks-wrapper a")).size()>0) // PNB and SBI
			{
				driver.findElement(By.cssSelector("div.footerlinks-wrapper a")).getAttribute("href");
				System.out.println("Json Footer API is present");

			}
			else if(driver.findElements(By.cssSelector("div.footer-links-wr a")).size()>0) // Aakash
			{
				driver.findElement(By.cssSelector("div.footer-links-wr a")).getAttribute("href");
				System.out.println("Quick Links Json Footer API is present");

			}
			else if(driver.findElements(By.cssSelector(".footer-wrapper a")).size()>0) // Hero Footer
			{
				driver.findElement(By.cssSelector(".footer-wrapper a")).getAttribute("href");
				System.out.println("Hero Footer API is present");
	
			}
			else
			{
				System.out.println("Footer API is not present");
				error=true;
			}


		}catch (Exception e) {
			System.out.println(e.getMessage());
			apiutility.failcode(urls, e.getMessage());
//			dbconnection db= new dbconnection();
//			db.database(urls, "Fail");

		}
		if (error==true)
		{
			apiutility.failcode(urls, "Fail");
			//			dbconnection db= new dbconnection();
			//			db.database(urls, "Fail");
		}
		else
		{
			apiutility.Passcode(urls, "Pass");
			//			dbconnection db= new dbconnection();
			//			db.database(urls, "Pass");

		}
	}


	@DataProvider
	public Object[] dataprov() throws IOException { 
		System.out.println("@DataProvider");
		String[] data = readXLSXFileurl();
		return data;
	}

	public static String[] readXLSXFileurl() throws IOException {
		System.out.println("a");
		InputStream excelFileName = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\APIForHeaderAndFooter\\readclientapi.xlsx");


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

	@AfterTest
	public void aftertest() {
		if(super.a>0)

		{
			System.out.println(super.a);
			sendmail.mail("Fail : Please check Header and Footer API Report");
		}
		else
		{

			sendmail.mail("Pass : Please check Header and Footer API Report");
		}
		super.a=0;
		driver.quit();

		File deletefileallure = new File(System.getProperty("user.dir")+ "\\allure-results");
		for(File file: deletefileallure.listFiles()) { 
			System.out.println("enter in allure");
			if (!file.isDirectory()) { 
				file.getPath();
				file.delete();
				System.out.println("Files deleted"+file.getName());
			}
		}

	}
}







