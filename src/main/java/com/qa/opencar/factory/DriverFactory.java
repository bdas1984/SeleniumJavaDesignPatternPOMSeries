package com.qa.opencar.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver int_driver(String browserName) {
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Please pass the correct browser :" + browserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.opencart.com/index.php?route=account/login");
		
		return driver;
		
	}
	
	public Properties init_prop() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/Config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
