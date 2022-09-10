package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
	
   private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}
	public  List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void doSendKeys(By locator, String Value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(Value);
		
	}
	
	public boolean isdisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String dogetText(By locator) {
		 return getElement(locator).getText();
	}
	
	public String doGetPageTitle() {
		return driver.getTitle();
	}
	
	
	
	/**
	 * Description :- This method will return the element text list.
	 * @param locator
	 * @return list of element text.
	 */
	
	public  List<String> getElementsText(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		
		for (WebElement e : eleList) {
			if (!e.getText().isEmpty()) {
			eleTextList.add(e.getText());
			}
		}
		
		return eleTextList;
	}
	
	public  void doSelectDropDownbyIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
				
	}
	
	public  void doSelectDropDownbyValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public  void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public  void  doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> country_list = select.getOptions();
		System.out.println(country_list.size());
		
		for (WebElement e : country_list) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();	
				break;
			}
				
		}
		
		
	}
	
	public  void doSelectvaluewithoutSelect(By locator, String value) {
		List<WebElement> countList = getElements(locator);
		for(WebElement e : countList) {
			if (e.getText().contains(value)) {
				e.click();
				break;
			}
		}
		
	}
	


}
