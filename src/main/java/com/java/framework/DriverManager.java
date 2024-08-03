package com.java.framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver driver;	
	public static Logger log=Logger.getLogger("log");
	public WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
	public void takeScreenshot(WebDriver driver) {
		try {
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			File destFile=new File(System.getProperty("user.dir")+"\\test-output\\Screenshots\\Screenshot_"+timeStamp+".jpg");
			//Copy file at destination
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
