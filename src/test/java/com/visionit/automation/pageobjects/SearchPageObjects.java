package com.visionit.automation.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import junit.framework.Assert;

public class SearchPageObjects {
	private static final Logger logger=LogManager.getLogger(SearchPageObjects.class);
	WebDriver driver;
	Scenario scn;
	
	
	//Locators
	//private By  searchBoxElement=By.id("twotabsearchtextbox");
	private By ListOfProductElement=By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//h2/a");
	
	public SearchPageObjects(WebDriver driver,Scenario scn)
	{
		this.driver=driver;
		this.scn=scn;

	}
	
	//search page method
	public void ValidateSearchPageTitle()
	{
		WebDriverWait webDriverWait1=new WebDriverWait(driver,20);
		webDriverWait1.until(ExpectedConditions.titleContains("Amazon.in :"));
		logger.info("wait until \"Amazon.in : Laptop\" is appears ");
		Assert.assertEquals("Page Title validation", true,driver.getTitle().contains("Amazon.in :"));
		logger.info("Page title validation successful :" + driver.getTitle());
		scn.log("Page title validation successful :" + driver.getTitle());
	    
	}
	public void ClickOnFirstProd()
	{
		List<WebElement> productlist=driver.findElements(ListOfProductElement);
		logger.info("created webelement for productlist");
		logger.info("number of product searched " +productlist.size());
		scn.log("number of product searched " +productlist.size());
		productlist.get(0).click();
		scn.log("clicked on first link in the list. Link Text "+productlist.get(0).getText());
		logger.info("clicked on first link in the list. Link Text "+productlist.get(0).getText());
	}
	

}
