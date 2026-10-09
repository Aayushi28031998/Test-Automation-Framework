package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOld {

	public static void main(String[] args) {
     
		WebDriver wd=new ChromeDriver();  //launch a browser window!! Session is created
	   
		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");
		browserUtility.maximizeWindow();
	 
	   By signInLinkLocator =By.xpath("//a[contains(text(),\"Sign\")]"); 
	   browserUtility.clickOn(signInLinkLocator);
	  
	  
	  By emailTextBoxLocator=By.id("email");
	 browserUtility.enterText(emailTextBoxLocator,"bakomam596@skrak.com");
	 
	  By passwordTextBoxLocator=By.id("passwd");
	browserUtility.enterText(passwordTextBoxLocator, "password");
	  
	  
	  
	  By submitLoginButtonLocator=By.id("SubmitLogin");
	  browserUtility.clickOn(submitLoginButtonLocator);
	}

}
