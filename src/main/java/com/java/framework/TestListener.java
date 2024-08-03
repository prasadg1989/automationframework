package com.java.framework;

import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener extends DriverManager implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		try {
			takeScreenshot(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
