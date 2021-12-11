package com.testingshastra.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeywords;

public class JoinMeetingPage {
	UIKeywords keyword = UIKeywords.getInstance();

//	first approach -POM
	//@FindBy(how = How.CSS,using = "h2.m-txt")
	@FindBy(css = "div.joinmeeting")
	public WebElement quickJoinMeetingTitle;

	public JoinMeetingPage() {
		// initElements() method set the lazyProxy(late Attendance) of each
		// element,Instance variable late loaded in memory
		// when we can perform the action(click,sendkeys,enter) of that instance
		// variable then It's loaded in memory otherwise not loaded
		PageFactory.initElements(keyword.driver, this);// we write this cause this represents current class instance
	}

//	// Second approach -POM
//	public By quickJoinMeetingTitle = By.cssSelector("div#navbarContent li:nth-child(1)");// Type of variable is By
//	// By is class,It's having the all static method & it's returns the By class's instance
 
	public String getQuickJoinMeetingTitle() {
		 return quickJoinMeetingTitle.getText();
		//return keyword.driver.findElement(quickJoinMeetingTitle).getText();
	}

}