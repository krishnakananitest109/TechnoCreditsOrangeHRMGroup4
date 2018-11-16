package com.technocredits.orangeHRM.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PredefinedMethods {

	static WebDriver driver;
	static WebDriverWait wait;

	public void initialization() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Aakanksha\\Technocredits\\Selenium\\Selenium_Required_Software_Jars\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		driver.manage().window().maximize();

		// apply explicit wait to every element
		wait = new WebDriverWait(driver, 30);

		/*
		 * //if page takes max 30 sec to load then to be with performance :can
		 * add below driver.manage().timeouts().pageLoadTimeout(30,
		 * TimeUnit.SECONDS);
		 */
	}

	// enter value in the given textbox
	public void setText(String locator, String value) {
		getElement(locator).sendKeys(value);
	}

	// will give text of the attribute
	public String getText(String locator) {
		return getElement(locator).getText();
	}

	// will give value of the locator
	public String getAttributeValue(String locator) {
		return getElement(locator).getAttribute("value");
	}

	// mousehover
	public void expandMenu(String locator) {
		Actions builder = new Actions(driver);
		builder.moveToElement(getElement(locator)).build().perform();
	}

	// click on given link-locator value
	public void click(String locator) {
		// need to check first that element is clickable
		WebElement ele = getElement(locator);
		boolean clickableFlag = verifyElementToBeClickable(ele);
		if (clickableFlag)
			ele.click();
	}

	// check whether element is clickable and return true/false
	public boolean verifyElementToBeClickable(WebElement ele) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			System.out.println(ele+" is not clickable");
			return false;
		}
		return true;
	}

	// return current page URL
	public String getURL() {
		return driver.getCurrentUrl();
	}

	// split method who will accept string and split it by given expression;
	// further it will return the element of user given index
	public String splitString(String input, String regExp, int index) {
		String[] inputSpilt = input.split(regExp);
		return inputSpilt[index];
	}

	// this method returns Used Locator Type
	private String getLocatorType(String locator) {
		String arrIndex = splitString(locator, "]: ", 0);
		// locator path starts with [; to remove '[', we use substring and
		// converted into upper case
		return arrIndex.substring(1).toUpperCase();
	}

	// this method return used locator's value
	private String getLocatorValue(String locator) {
		return splitString(locator, "]: ", 1);
	}

	// webdriver wait's different methods
	// check whether element is visible and return true/false
	public boolean verifyElementToBeVisible(String locator) {
		try {
			WebElement ele = getElement(locator);
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			System.out.println("Element is not clickable");
			return false;
		}
		return true;
	}

	// return WebElement : implemented string functions
	public WebElement getElement(String locator) {

		String locatorType = getLocatorType(locator);
		String locatorValue = getLocatorValue(locator);

		// take an element to store and return
		WebElement element = null;

		// use javascriptexecutor to highlight the locator
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// use switch case to use different Xpaths
		switch (locatorType) {

		case "XPATH":
			// applied explicit wait to the element
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(locatorValue))));
			break;

		case "ID":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id(locatorValue))));
			break;

		case "NAME":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.name(locatorValue))));
			break;

		case "CLASSNAME":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.className(locatorValue))));
			break;

		case "LINKTEXT":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.linkText(locatorValue))));
			break;

		case "PARTIALLINKTEXT":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.partialLinkText(locatorValue))));
			break;

		case "CSSELECTOR":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(locatorValue))));
			break;

		case "TAGNAME":
			element = driver.findElement(By.tagName(locatorValue));
			break;
		}
		// highlight element
		jse.executeScript("arguments[0].style.border='red solid 3px'", element);
		return element;

	}

}
