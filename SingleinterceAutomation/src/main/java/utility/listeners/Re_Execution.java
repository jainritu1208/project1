package utility.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Re_Execution implements IRetryAnalyzer {

	int counter=0;
	int retryLimit=2;

	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			System.out.println("Retrying " + result.getName() + " again and the count is " + (counter+1));
			counter++;
			return true;
		}
		return false;
	}


}
