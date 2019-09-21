package com.zoopla.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.zoopla.qa.testdata.TestData;

public class BasePage {

	public static WebDriver driver;
	public static Properties prop;

	public BasePage() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\pkshank\\eclipse-workspace\\Zoopla_Test_Suite\\src\\main\\java\\com\\zoopla\\qa\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static void initialization() {

		if (prop.getProperty("browser").equalsIgnoreCase("FIREFOX")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\pkshank\\eclipse-workspace\\Enrich_Automation_Framework\\Browser Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("CHROME")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pkshank\\eclipse-workspace\\Enrich_Automation_Framework\\Browser Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\pkshank\\eclipse-workspace\\Enrich_Automation_Framework\\Browser Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else {

			System.out.println(
					"Accepted browsers are Chrome, Firefox and Internet Explorer : Please enter a valid browser in config.properties file");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestData.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestData.implicitlyWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
