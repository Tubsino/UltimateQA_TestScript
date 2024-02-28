package utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Application Launched");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On test success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Utils takeScreenshot = new Utils();
		try {
			takeScreenshot.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
