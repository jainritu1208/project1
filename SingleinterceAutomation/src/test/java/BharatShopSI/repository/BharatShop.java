package BharatShopSI.repository;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BharatShopSI.utility.CommonFunctions;
import BharatShopSI.utility.excelSheetUtility;

public class BharatShop extends CommonFunctions {
	static utility.Driver.SingletonClassChromeNew singleton = utility.Driver.SingletonClassChromeNew.getInstanceOfSingletonBrowserClass();
	static WebDriver driver = singleton.getDriver();
	static int code=0;
	static String excelFileName = "Bharatwritesheet.xls";
	static HttpURLConnection conn;
	static int failcount=0;
	
		BharatShop() throws IOException{
		excelSheetUtility.headerValues();		
	}
	
	@DataProvider
	public Object[] dp() throws IOException {
		String[] data = readXLSXFile();
		return data;
	}

	@Test(dataProvider = "dp")
	public void prepod(String urls) throws Exception {
//		System.out.println("fail;
		 boolean error=false;
		try {

			driver.get(urls);
			Thread.sleep(3000);
			String geturl = driver.getCurrentUrl();
			System.out.println(geturl);
//			code = getResponseCode(geturl);
			 conn = (HttpURLConnection)new URL(driver.getCurrentUrl()).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			System.out.println(conn.getResponseCode()+conn.getResponseMessage());
			if(conn.getResponseCode()==200 ||conn.getResponseCode()==403){
				System.out.println("Success");
			}else {
				error=true;
			}
			
			if (conn.getResponseCode()==200 ||conn.getResponseCode()==403) {

				if(urls.endsWith("error.html")) {
					System.out.println("Page load error");
					error=true;
				}
				//code for sanity sites:
				if(driver.findElements(By.cssSelector(".navbar-brand")).size()>0) {
					System.out.println("Logo get");
					Thread.sleep(2000);
					if(urls.startsWith("https://bharat.shop/")) {
						Thread.sleep(1000);
						String text = driver.findElement(By.cssSelector("p.fadeInUp.customText.animated")).getText();
						System.out.println(text);
						
						if (text.equals("Launch <YourBrand>.bharat.shop' website In just 3 simple steps.")) {
							System.out.println("Pass");
							//pass code
							excelSheetUtility.Passcode(urls, conn.getResponseCode(), "Pass");
							failcount=0;
							
						}else {
							System.out.println("1");
							error=true;
						}

					}else if(urls.startsWith("https://web.bharat.shop/")) {
						driver.findElement(By.cssSelector("a.btn.btn-white")).click();
						String text = driver.findElement(By.className("error")).getText();

						if (text.equals("Please enter valid mobile number."))
						{
							System.out.println("Pass");
							//Pass code
							excelSheetUtility.Passcode(urls, conn.getResponseCode(), "Pass");	
							failcount=0;
						}else {
							System.out.println("2");
							error=true;
						}
					}

				}else if(driver.findElements(By.cssSelector(".text-logo ")).size()>0) {
					System.out.println("Logo get2");
					if(urls.startsWith("https://srbnissancachar")) {
						String title = driver.getTitle();
						System.out.println(title);
						if(driver.getPageSource().contains("The Store you're looking for isn't available.")) {
							error=true;
							System.out.println("store no available");
//							excelSheetUtility.failcode(urls, conn.getResponseCode(), "Store Not available.");
						}
						
						else if(driver.getTitle().equals(title)) {
							System.out.println("Pass");
							//pass code
							excelSheetUtility.Passcode(urls, conn.getResponseCode(), "Pass");
							failcount=0;
					}else {
						System.out.println(" else no available");
							System.out.println("3");
							error=true;
						}

					}else if(urls.startsWith("https://upadhyayagriculturefarms")) {
						String title = driver.getTitle();
						if(driver.getTitle().equals(title)) {
							System.out.println("Pass");
							//pass code
							excelSheetUtility.Passcode(urls, conn.getResponseCode(), "Pass");
							failcount=0;
						}else {
							System.out.println("4");
							error=true;
						}
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Exception caught: ");
			System.out.println(e.getMessage());
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("@@@@@@@@@@@@@@@@@");
			error=true;
		}
		if(error==true) {
			System.out.println("Fail and final fail");
			//fail code
			if(failcount==2) {
			excelSheetUtility.failcode(urls, conn.getResponseCode(), "Fail");
			System.out.println("written in sheet fail");	
			}else {
			failcount++;
			Assert.fail();
			}
		}
		if(failcount==2) {
			failcount=0;
		}
		
	}

	@AfterTest
	public void aftertest() throws IOException, ClassNotFoundException {
//		
//		Bharataws obj = new Bharataws();
//		obj.s3(excelFileName);
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


