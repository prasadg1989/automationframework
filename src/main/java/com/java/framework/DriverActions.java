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
		return flag;
	}
	
}
