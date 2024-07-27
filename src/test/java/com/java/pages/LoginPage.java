package com.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By userNameLocBy=By.id("user-name");
	public By passwordLocBy=By.id("password");
	public By loginBtnLocBy=By.id("login-button");
	public By productsLocBy=By.xpath("//span[text()='Products']");
	public By loginErrorLocBy=By.xpath("//h3[@data-test='error']");
	
}
