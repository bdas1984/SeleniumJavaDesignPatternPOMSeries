package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	
	private ElementUtil elementUtil;
	
	
	//Page always need to create By locators
	
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.xpath("//div[@class='col-sm-6 text-right']//a[text()='Forgot your password?']");
	
	public LoginPage(WebDriver driver) {
		
		elementUtil = new ElementUtil(driver);
	
		
	}
	
	public String getLoginPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public boolean isPasswordForgotlinkDisplayed() {
		return elementUtil.isdisplayed(forgotPwdLink);
	}
	
	public void doLogin(String un, String pwd) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
	}

}
