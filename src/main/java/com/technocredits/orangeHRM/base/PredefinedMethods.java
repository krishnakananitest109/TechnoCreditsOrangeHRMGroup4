package com.technocredits.orangeHRM.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PredefinedMethods {

	static WebDriver driver;
	
	public void initialization(){
		System.setProperty("webdriver.chrome.driver","E:\\Aakanksha\\Technocredits\\Selenium\\Selenium_Required_Software_Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//if page takes max 30 sec to load then to be with performance :can add below
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	//enter value in the given textbox
	public void setText(String locator, String value){
		getElement(locator).sendKeys(value);
	}
	
	//click on given link-locator value
	public void click(String locator){
		getElement(locator).click();
	}
	
	//return current page URL
	public String getURL(){
		return driver.getCurrentUrl();
	}
	
	//return WebElement
	public WebElement getElement(String locator){
		return driver.findElement(By.xpath(locator));
	}
	
	//mousehover
	public void expandMenu(String locator){
		Actions builder = new Actions(driver);
		builder.moveToElement(getElement(locator)).build().perform();
	}
	
}
