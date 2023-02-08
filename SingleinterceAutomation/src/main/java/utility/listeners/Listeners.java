package utility.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners  implements ITestListener  {
	
	static utility.Driver.SingletonClassChromeNew singleton = utility.Driver.SingletonClassChromeNew.getInstanceOfSingletonBrowserClass();
	static WebDriver driver = singleton.getDriver();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("the test case failed is"+result.getName());
		String user_dir=System.getProperty("user.dir");
		String customDir="\\screenshot\\";
		System.out.println("this is user dir"+System.getProperty("user.dir"));
		String scshotname=user_dir + customDir + new SimpleDateFormat("mmddhhss").format(Calendar.getInstance().getTime())+ result.getName()+".png";
		System.out.println("this is screenshot name"+scshotname);
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile,new File(scshotname));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("the test case skipped is"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
