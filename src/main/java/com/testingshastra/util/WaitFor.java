package com.testingshastra.util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testingshastra.keywords.UIKeywords;

//I have created a wait class where custome waits have been written their & i was using those custom waits while writting the yest cases

public class WaitFor {
	private static final WebDriverWait wait;
	
	static {
		wait = new WebDriverWait(UIKeywords.getInstance().driver, Duration.ofSeconds(10));//creating wait Object
	    wait.pollingEvery(Duration.ofMillis(500));
	}
	
	  //instead of constructor using static block
//	  public WaitFor() {
//		wait = new WebDriverWait(UIKeywords.getInstance().driver, Duration.ofSeconds(10));//creating wait Object
//	    wait.pollingEvery(Duration.ofMillis(500));
//	    //above,we can say is basic configration
//	}
	
	public void visibilityOfElement(WebElement element,int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
        public static void stalenessOfElement(WebElement element, int duration) {
        	wait.withTimeout(Duration.ofSeconds(duration));
    		wait.ignoring(NoSuchElementException.class);
    		wait.until(ExpectedConditions.stalenessOf(element));
		}

//        public void elementToBeClickable(WebElement element, int duration) {
//        	wait.withTimeout(Duration.ofSeconds(duration));
//    		wait.ignoring(NoSuchElementException.class);
//    		wait.until(ExpectedConditions.elementToBeClickable(element));
//		}
        //Instead of above method we can create this below method because user can override this method for int Duration(here is using overloading[OOPs concepts])
        
        /**
         * This method waits for element to be clickable.
         * Max timeout is 30 seconds which is not configurable
         * @param element
         */
        public static void elementToBeClickable(WebElement element) {
        	wait.withTimeout(Duration.ofSeconds(30));
    		wait.ignoring(NoSuchElementException.class);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
}
