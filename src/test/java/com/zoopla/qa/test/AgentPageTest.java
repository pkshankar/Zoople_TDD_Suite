package com.zoopla.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zoopla.qa.pages.AgentPage;
import com.zoopla.qa.pages.BasePage;
import com.zoopla.qa.pages.PropertyDetailPage;
import com.zoopla.qa.pages.PropertySearchResultPage;
import com.zoopla.qa.testutil.TestUtil;

public class AgentPageTest extends BasePage {

	PropertySearchResultPage propertySearchResultPage;
	PropertyDetailPage propertyDetailPage;
	AgentPage agentPage;

	public AgentPageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		propertySearchResultPage = new PropertySearchResultPage();
		propertyDetailPage = new PropertyDetailPage();
		agentPage = new AgentPage();
		propertySearchResultPage.enterCityName();
		propertySearchResultPage.selectFifthProperty();
		TestUtil.writeToProperties(propertyDetailPage.getAgentName().getText(),
				propertyDetailPage.getAgentPhoneNo().getText());

	}

	@Test(priority = 1, description = "VALIDATE AGENT NAME")
	public void validateAgentNameIsCorrect() {

		propertyDetailPage.clickAgentName();
		Assert.assertEquals(agentPage.getAgentNameAgentPage(), TestUtil.writeProp.getProperty("AGENT_NAME"));

	}

	@Test(priority = 2, description = "VALIDATE AGENT PHONE NO.")
	public void validateAgentPhoneNoIsCorrect() {

		propertyDetailPage.clickAgentName();
		Assert.assertEquals(agentPage.getAgentPhoneNoAgentPage().replaceAll("[^0-9]", ""),
				TestUtil.writeProp.getProperty("AGENT_PHONE_NO").replaceAll("[^0-9]", ""));

	}

	@AfterMethod
	public void teatDown() {

		driver.quit();
	}

}
