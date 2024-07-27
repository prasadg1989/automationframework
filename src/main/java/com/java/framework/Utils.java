package com.java.framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
	
	public void takeScreenshot(WebDriver driver) {
		try {
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			File destFile=new File(System.getProperty("user.dir")+"\\test-output\\Screenshots\\Screenshot_"+timeStamp+".jpg");
			//Copy file at destination
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
