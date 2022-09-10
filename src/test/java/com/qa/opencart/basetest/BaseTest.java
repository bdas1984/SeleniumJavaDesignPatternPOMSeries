package com.qa.opencart.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencar.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	DriverFactory df;
	private WebDriver driver;
	
	public LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		driver = df.int_driver("chrome");
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
