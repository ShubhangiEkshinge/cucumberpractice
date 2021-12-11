package com.testingshastra.stepdefinition;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.testingshastra.config.Application;
import com.testingshastra.keywords.UIKeywords;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {//In this class we only write StepDefinitions means methods
	public RemoteWebDriver driver = null;
	UIKeywords keyword = UIKeywords.getInstance();
	
	//@Before //Annotation of cucumber,Run before each Scenario
	public void setUp() {
		Application app = new Application();
		String browserName = app.getBrowser();
		keyword.openBrowser(browserName);
		this.driver = keyword.getDriver();
		driver.get(app.getAppUrl());
	}
	
	//@After//Annotaion of cucumber,after each scenario will be executed
	public void tearDown() {
		driver.quit();
		
	}
	
//	@Given("The chrome browser is launched")
//	public void the_chrome_browser_is_launched() {
//		Application app = new Application();
//		String browserName = app.getBrowser();
//		keyword.openBrowser(browserName);
//		this.driver = keyword.getDriver();
//	}
//
//	@And("The url of application is aslo launched")
//	public void the_url_of_application_is_aslo_launched() {
//		Application app = new Application();
//		driver.get(app.getAppUrl());
//		
//	}

	@Then("Verify the title of homepage is {string}")//string s small here,parameterized stepdefinition
	public void verify_the_title_of_homepage(String  expectedTitle) {//Parameterized
		String actualTitle = driver.getTitle();
		//Assert.assertEquals(actualTitle, "IJMeet");//If we can't use Assertion then each scenario is passed always
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
//	@Given("I have {int} and {int}")
//	public void i_have_and(Integer int1, Integer int2) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

}
