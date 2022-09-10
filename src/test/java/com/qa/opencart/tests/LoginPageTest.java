package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
	
	@Test(priority = 1)
	public void test_LoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title" + title);
		Assert.assertEquals(title, Constants.LoginPage_Title);
		
	}
	
	@Test(priority =3)
	public void tes_ForgotPasswordLink() {
		Assert.assertTrue(loginPage.isPasswordForgotlinkDisplayed());
	}
	
	@Test
	public void test_LoginTest() {
		loginPage.doLogin("das.biswajeet@gmail.com", "Bdas@1984");
	}


}
