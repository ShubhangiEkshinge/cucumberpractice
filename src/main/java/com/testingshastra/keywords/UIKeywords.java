package com.testingshastra.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testingshastra.config.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains UI Keywords which are applicable for webElements and
 * general actions This is a singleton Class.To create object of this class,use
 * {@code getInstance()} method
 * 
 * @author Shubhangi Ekshinge
 *
 */
public class UIKeywords {
	// public static RemoteWebDriver driver = null;
	public RemoteWebDriver driver = null;
	// Using sigleton pattern to solve the null initialzation problem
	private static final UIKeywords uikeywords;

	static {
		uikeywords = new UIKeywords();
	}

	public static UIKeywords getInstance() {
		return uikeywords;
	}

	private UIKeywords() { // Make the constructor is private for singleton

	}

	/**
	 * This keyword is used to launch specified browser.
	 * 
	 * @param browserName must be one of the followung
	 *                    <ul>
	 *                    <li>chrome</li>
	 *                    <li>firefox</li>
	 *                    <li>ie</li>
	 *                    <li>edge</li>
	 *                    </ul>
	 */

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browserName:" + browserName);
		}
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {// overloading concepts
		WebElement element = null;
		if (locatorValue.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("ClassName")) {
			element = driver.findElement(By.className(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locatorValue));
		}
		return element;

	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void enterText(WebElement element, String textToEnter) {// It's take arguments as an WebElement(for finding
																	// the WebElement)
		element.sendKeys(textToEnter);
	}

	/**
	 * In next version of framework, this method will be deleted. instead we can use
	 * enterText{String object,String testToEnter}
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @param textToEnter
	 */
	@Deprecated // this method is there but not in used,It's deleted from the new version of
				// framework
	public void enterText(String locatorType, String locatorValue, String textToEnter) {// It's also the finding the
																						// WebElement but with the help
																						// of locatorType &locatorValue
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
		// element.sendKeys(textToEnter);
//		if (locatorValue.equalsIgnoreCase("xpathy")) {
//			driver.findElement(By.xpath(locatorValue)).sendKeys(textToEnter);
//		}
//		if (locatorValue.equalsIgnoreCase("css")) {
//			driver.findElement(By.cssSelector(locatorValue)).sendKeys(textToEnter);
//		}
//		if (locatorValue.equalsIgnoreCase("id")) {
//			driver.findElement(By.id(locatorValue)).sendKeys(textToEnter);
//		}
//		if (locatorValue.equalsIgnoreCase("name")) {
//			driver.findElement(By.name(locatorValue)).sendKeys(textToEnter);
//		}
//		if (locatorValue.equalsIgnoreCase("ClassName")) {
//			driver.findElement(By.className(locatorValue)).sendKeys(textToEnter);
//		}
//		if (locatorValue.equalsIgnoreCase("tagName")) {
//			driver.findElement(By.tagName(locatorValue)).sendKeys(textToEnter);
//		}//avoid duplicacy 
	}

	public void swithToFrameAt(int index) {
		driver.switchTo().frame(index);
	}

	public void swithToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void swithToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}

	public void switchToDefaulContent() {
		driver.switchTo().defaultContent();
	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public RemoteWebDriver getDriver() { // get the driver,It's return driver instance
		return driver;
	}

	public void click(WebElement element) {
		element.click();
	}

	public void click(String locatorType, String locatorValue) {//Method overloading
		getWebElement(locatorType, locatorValue).click();
		if (locatorValue.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		}
		if (locatorValue.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		}
		if (locatorValue.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		}
		if (locatorValue.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
		}
		if (locatorValue.equalsIgnoreCase("ClassName")) {
			driver.findElement(By.className(locatorValue)).click();
		}
		if (locatorValue.equalsIgnoreCase("tagName")) {
			driver.findElement(By.tagName(locatorValue)).click();
		}

	}

	public void enterText(String object, String textToEnter) {
		String[] parts = object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);
	}

	public void click(String Object) {
		String[] parts = Object.split("##");
		getWebElement(parts[0], parts[1]).click();
	}
}
