package com.testingshastra.uitests;

import org.apache.log4j.Logger;
import org.testng.Assert;
//import org.testng.annotations.Listeners;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.util.Locator;
//import com.testingshastra.util.TestListener;
import com.testingshastra.util.WaitFor;

//@Listeners(TestListener.class) //If we create <listeners> in testng.xml then in class level we don't need to write @listeners
public class SignupPageTests extends BaseClass {
	//If we want to write the class's log  the create one private static final variable
	private static final Logger LOG = Logger.getLogger(SignupPageTests.class);
	UIKeywords keyword = UIKeywords.getInstance();


	@Test
	public void validateFulltNameFieldForCorrectInput() {
		//keyword.launchUrl("https://www.IJmeet.com");
		String url ="https://ijmeet.com/";
		keyword.launchUrl(url);
		LOG.info("Url is  launched:"+url);//for printimg the message using log4j

		// Approach 1
//     WebElement signUp = keyword.getDriver().findElement(By.cssSelector("li:nth-child(5) a.nav-link"));
//     keyword.click(signUp);

		// Approach 2
		keyword.click("css", "li:nth-child(5) a.nav-link");
		LOG.info("Clicked on Register button");
		// keyword.enterText("css", "input#name", "Shubhangi Ekshinge");
		keyword.enterText(Locator.SINGUP_FULLNAME, "Shubhangi Ekshinge");
		keyword.enterText(Locator.SINGUP_COMPANYNAME,"New Company");
		keyword.enterText(Locator.SIGNUP_EMAIL, "shubhangiekshinge05@gmail.com");
		keyword.enterText(Locator.SIGNUP_CONTACT, "7798766225");
		keyword.enterText(Locator.SIGNUP_PASSWORD, "Agni@123");
		keyword.swithToFrameAt(0);
		LOG.info("Switched inside a frame");
		WaitFor.elementToBeClickable(keyword.getWebElement("css","div.recaptcha-checkbox-border"));
		keyword.click(Locator.SIGNUP_IANNOTROBOT);
		//keyword.click("css", "div.recaptcha-checkbox-border");
		keyword.switchToDefaulContent();
		LOG.info("Jumped back from frame");
		keyword.click(Locator.SIGNUP_SIGNUPBTN);
		String actualUrl = keyword.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("register"));
	}

}
