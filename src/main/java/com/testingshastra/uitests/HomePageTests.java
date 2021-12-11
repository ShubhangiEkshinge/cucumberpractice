package com.testingshastra.uitests;

//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.pages.HomePage;
import com.testingshastra.pages.JoinMeetingPage;

public class HomePageTests extends BaseClass{
	UIKeywords keyword = UIKeywords.getInstance();

	@Test
	public void verifyTitleofHomePage() {
		String expectedTitle = "IJmeet";
		Assert.assertEquals(keyword.driver.getTitle(), expectedTitle);
	}

	@Test
	public void verifyIfUserRedirectsToJoinMeetingPage() throws InterruptedException {
		//when we using @FindBy annotation that time we create the object of class with the help of PageFactory(c) 
		//HomePage home = PageFactory.initElements(keyword.driver, HomePage.class);
		HomePage home  = new HomePage();
		home.rightClickOnNavBar();
		Thread.sleep(5000);
		home.clickOnJoinMeetingTab();
		//JoinMeetingPage JoinMeeting = PageFactory.initElements(keyword.driver, JoinMeetingPage.class);
		JoinMeetingPage JoinMeeting = new JoinMeetingPage();
		//WaitFor.elementToBeVisible(joinMeeting.quickJoinMeetingTitle,10);//If element late loaded in memory then use it 
		String actual = JoinMeeting.getQuickJoinMeetingTitle();
		Assert.assertTrue(actual.contains("Quick"),"Actual Heading:"+actual);

	}
	@Test
	public void printAllInfoLinks() { //It's a element specific method
		HomePage home = new HomePage();
		home.getTextOfInfoLinks();

	}
}
