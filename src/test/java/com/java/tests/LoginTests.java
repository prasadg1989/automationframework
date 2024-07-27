package com.java.tests;

import org.testng.annotations.Test;

import com.java.framework.DriverActions;
import com.java.framework.DriverManager;
import com.java.pages.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class LoginTests {
	public WebDriver driver;
	DriverManager driverManager;
	DriverActions driverActions;
	LoginPage loginPage;
  @BeforeTest
  public void beforeTest() {
	  driverManager=new DriverManager();
	  driver=driverManager.getDriver("chrome");
	  loginPage=new LoginPage(driver);
	  driverActions=new DriverActions(driver);
	  driver.get("https://www.saucedemo.com/");
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  
  @Test(groups= {"RegressionTest", "SmokeTest"})
  public void validLogin() {
	  driverActions.waitForElement(loginPage.userNameLocBy);
	  driverActions.enterText(loginPage.userNameLocBy, "standard_user");
	  driverActions.enterText(loginPage.passwordLocBy, "secret_sauce");
	  driverActions.click(loginPage.loginBtnLocBy);
	  driverActions.waitForElement(loginPage.productsLocBy);
  }
  
  @Test(groups= {"RegressionTest", "SmokeTest"})
  public void emptyLogin() {
	  
  }
  
  @Test(groups= {"RegressionTest"})
  public void inValidPasswordLogin() {
	  
  }
  
  @Test(groups= {"RegressionTest"})
  public void inValidUserNameLogin() {
	  
  }

}