package com.zoopla.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.pages.BasePage;
import com.zoopla.qa.pages.PropertyDetailPage;
import com.zoopla.qa.pages.PropertySearchResultPage;

public class PropertyDetailPageTest extends BasePage {

	PropertySearchResultPage propertySearchResultPage;
	PropertyDetailPage propertyDetailPage;

	public PropertyDetailPageTest() {

		super();
	}

	@BeforeMethod()
	public void setUp() {

		initialization();
		propertySearchResultPage = new PropertySearchResultPage();
		propertyDetailPage = new PropertyDetailPage();
		propertySearchResultPage.enterCityName();
		propertySearchResultPage.selectFifthProperty();
	}

	@Test(priority = 1, description = "VALIDATE THAT AGENT LOGO IS DISPLAYED")
	public void isAgentLogoDisplayed() {

		Assert.assertTrue(propertyDetailPage.isAgentLogoDisplayed());
	}

	@Test(priority = 2, description = "VALIDATE THAT AGENT NAME IS DISPLAYED")
	public void isAgentNameDisplayed() {

		Assert.assertTrue(propertyDetailPage.getAgentName().isDisplayed());
	}

	@Test(priority = 3, description = "VALIDATE THAT AGENT PHONE NO. IS DISPLAYED")
	public void isAgentPhoneNoDisplayed() {

		Assert.assertTrue(propertyDetailPage.getAgentPhoneNo().isDisplayed());
	}

	@AfterMethod()
	public void tearDown() {

		driver.quit();
	}
}
