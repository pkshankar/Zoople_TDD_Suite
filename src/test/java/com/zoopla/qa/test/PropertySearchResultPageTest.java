package com.zoopla.qa.test;

import java.util.ArrayList;
import java.util.Collections;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zoopla.qa.pages.BasePage;
import com.zoopla.qa.pages.PropertySearchResultPage;

public class PropertySearchResultPageTest extends BasePage {

	PropertySearchResultPage propertySearchResultPage;

	public PropertySearchResultPageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		propertySearchResultPage = new PropertySearchResultPage();
		propertySearchResultPage.enterCityName();

	}

	@Test(priority = 1, description = "PRINT PROPERTIES PRICE IN DESCENDING ORDER")
	public void getPropertyPriceListDescendingOrderTest() {

		ArrayList<Integer> propPriceDesc = propertySearchResultPage.getPropertyPriceList();
		Collections.sort(propPriceDesc, Collections.reverseOrder());
		System.out.println("PROPERTY PRICE IN DESCENDING ORDER");
		System.out.println("**********************************");
		for (Integer i : propPriceDesc) {

			System.out.println(i);
		}

	}

	@Test(priority = 2, description = "SELECT FIFTH PROPERTY IN THE LIST")
	public void selectFifthPropertyTest() {

		propertySearchResultPage.selectFifthProperty();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
