package com.java.framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverActions {
	public WebDriver driver;
	public DriverActions(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean click(WebElement element) {
		boolean flag=false;
		try {
			element.click();
			flag=true;
		}catch(Exception ex) {
			flag=false;
			ex.printStackTrace();
		}
		Log.reportResult(flag, "Successfully Clicked on the Element", "Failed to Click on the Element");
		return flag;
	}
	
	public boolean click(By locator) {
		boolean flag=false;
		try {
			driver.findElement(locator).click();
			flag=true;
		}catch(Exception ex) {
			flag=false;
			ex.printStackTrace();
		}
		Log.reportResult(flag, "Successfully Clicked on the Element", "Failed to Click on the Element");
		return flag;
	}
	
	public boolean enterText(WebElement element, String text) {
		boolean flag=false;
		try {
			element.sendKeys(text);
			flag=true;
		}catch(Exception ex) {
			flag=false;
			ex.printStackTrace();
		}
		Log.reportResult(flag, "Successfully Entered the Text: "+text, "Failed to Enter the Text: "+text);
		return flag;
	}
	
	public boolean enterText(By locator, String text) {
		boolean flag=false;
		try {
			driver.findElement(locator).sendKeys(text);
			flag=true;
		}catch(Exception ex) {
			flag=false;
			ex.printStackTrace();
		}
		Log.reportResult(flag, "Successfully Entered the Text: "+text, "Failed to Enter the Text: "+text);
		return flag;
	}
	
	public boolean clearEnterText(By locator, String text) {
		boolean flag=false;
		try {
			WebElement element=driver.findElement(locator);
			element.clear();
			element.sendKeys(text);
			flag=true;
		}catch(Exception ex) {
			flag=false;
			ex.printStackTrace();
		}
		Log.reportResult(flag, "Successfully Cleared and Entered the Text: "+text, "Failed to Clear and Enter the Text: "+text);
		return flag;
	}
	
	public boolean clear(By locator) {
		boolean flag=false;
		try {
			driver.findElement(locator).clear();
			flag=true;
		}catch(Exception ex) {
			flag=false;
			ex.printStackTrace();
		}
		Log.reportResult(flag, "Successfully Cleared the Text", "Failed to Clear the Text");
		return flag;
	}
	
	public boolean waitForElement(By locator) {
		boolean flag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			flag=true;
		}catch(Exception ex) {
			flag=false;
			ex.printStackTrace();
		}
		Log.reportResult(flag, "Successfully waited for the Element", "Failed to wait for the Element");
		return flag;
	}
	
	public boolean VerifyMessage(By locator, String expectedMessage) {
		boolean flag=false;
		String actualMessage=null;
		try {
			actualMessage=driver.findElement(locator).getText().trim();
			flag=true;
		}catch(Exception ex) {
			flag=false;
			ex.printStackTrace();
		}
		Log.reportResult(flag, "Successfully Verified the Message: "+expectedMessage, "Failed to verify the Message: "+expectedMessage);
		return flag;
	}
	
}
