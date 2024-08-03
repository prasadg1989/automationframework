package com.java.tests;

import org.testng.annotations.Test;
import com.java.framework.DriverActions;
import com.java.framework.DriverManager;
import com.java.framework.TestListener;
import com.java.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Listeners(TestListener.class)
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
	  driver.quit();
  }
  
  @Test(groups= {"RegressionTest", "SmokeTest"})
  public void validLogin() {
	  driverActions.waitForElement(loginPage.userNameLocBy);
	  driverActions.clearEnterText(loginPage.userNameLocBy, "standard_user");
	  driverActions.clearEnterText(loginPage.passwordLocBy, "secret_sauce");
	  driverActions.click(loginPage.loginBtnLocBy);
	  driverActions.waitForElement(loginPage.productsLocBy);
  }
  
  @Test(groups= {"RegressionTest", "SmokeTest"})
  public void emptyLogin() {
	  driverActions.waitForElement(loginPage.userNameLocBy);
	  driverActions.clear(loginPage.userNameLocBy);
	  driverActions.clear(loginPage.passwordLocBy);
	  driverActions.click(loginPage.loginBtnLocBy);
	  driverActions.waitForElement(loginPage.loginErrorLocBy);
	  driverActions.VerifyMessage(loginPage.loginErrorLocBy, "Epic sadface: Username is required");
  }
  
  @Test(groups= {"RegressionTest"})
  public void inValidPasswordLogin() {
	  driverActions.waitForElement(loginPage.userNameLocBy);
	  driverActions.clearEnterText(loginPage.userNameLocBy, "standard_user");
	  driverActions.clearEnterText(loginPage.passwordLocBy, "InvalidPassword");
	  driverActions.click(loginPage.loginBtnLocBy);
	  driverActions.waitForElement(loginPage.loginErrorLocBy);
	  driverActions.VerifyMessage(loginPage.loginErrorLocBy, "Epic sadface: Username and password do not match any user in this service");
  }
  
  @Test(groups= {"RegressionTest"})
  public void inValidUserNameLogin() {
	  driverActions.waitForElement(loginPage.userNameLocBy);
	  driverActions.clearEnterText(loginPage.userNameLocBy, "standard_user");
	  driverActions.clearEnterText(loginPage.passwordLocBy, "InvalidPassword");
	  driverActions.click(loginPage.loginBtnLocBy);
	  driverActions.waitForElement(loginPage.loginErrorLocBy);
	  driverActions.VerifyMessage(loginPage.loginErrorLocBy, "Epic sadface: Username and password do not match any user in this service");
  }

}