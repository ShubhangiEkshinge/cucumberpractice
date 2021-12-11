package com.testingshastra.pages;

import java.util.Iterator;
import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeywords;

//only we written the webElements in this class

public class HomePage {
	UIKeywords keyword = UIKeywords.getInstance();
	// @FindBy annotation of testNG using with the WebElement,Automaticaaly called
	// the driver instance & findElement() & set the variable with this locator
	//less chances to come staleElementException when we using @FindBy annotation because element late laod in memory
	//we can pass the value in diff ways to inside the @FindBy(how = How.CSS,using ="div#navbarContent li:nth-child(1)")
	
	//@CacheLookup//rarely used(project under development then don't use CacheLookup)each browser having local cache memory 
	@FindBy(css = "div#navbarContent li:nth-child(1)")
	public WebElement joinMeetingTab;

//	public HomePage() { //to initialize the WebElements 
//	   this.joinMeetingTab = keyword.driver.findElement(By.cssSelector("div#navbarContent li:nth-child(1)"));
//	}
	//when we want to list of webElements on page(initialize list of WebElements with the help of PageFactory)
	@FindBy(css = "div.footer-last-view-support div:nth-child(3) li a")
	public List<WebElement>infoLinks; //using Naming Convension plurals always
	
	//If we don't written @FindBy then ByDefault considered as Id or Name 
	public WebElement HostMeetiingTab; //written the element only doesn't initialize
	
	
	public WebElement navbarContent; //(It's name of the variable that present in page)written the element only doesn't initialize
	
	public HomePage() {
		PageFactory.initElements(keyword.driver, this);//we write this cause this represents current class instance
	}

	public void clickOnJoinMeetingTab() {
         joinMeetingTab.click();
	}
	
	public void getTextOfInfoLinks() {
      Iterator<WebElement> itr = infoLinks.iterator();
      while(itr.hasNext()) {
    	 System.out.println(itr.next().getText());//we use getText() becuase we make Iterator is generic,If It's remove then error comes
      }
	}
	public void rightClickOnNavBar() {
       Actions act = new Actions(keyword.driver);//gor right click we use Actions class
	   act.contextClick(navbarContent).build().perform();
	   
	}

}
