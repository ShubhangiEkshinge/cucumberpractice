package com.testingshastra.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testingshastra.keywords.UIKeywords;
//import com.testingshastra.util.PropertiesFile;

public class BaseClass {
	public  RemoteWebDriver driver = null;
	UIKeywords keyword = UIKeywords.getInstance();
	// UIKeywords keyword = new UIKeywords();
	Application app = new Application();

	@BeforeMethod
	public void setUp() {
		keyword.openBrowser(app.getBrowser());
		this.driver = keyword.getDriver();
		driver.get(app.getAppUrl());
		
//		keyword.openBrowser("chrome");
//		this.driver = keyword.getDriver();
//		driver.get(PropertiesFile.getProperty("/src/main/resources/application.properties", "https://www.dev.testingshastra.com"));
		
		//driver.get("https://www.IJmeet.com");
	}

	@AfterMethod
	public void tearDown() {
		keyword.quitBrowser();
	}
}
