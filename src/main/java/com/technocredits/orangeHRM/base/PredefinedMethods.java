package com.technocredits.orangeHRM.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.technocredits.orangeHRM.constant.CONSTANT;

public class PredefinedMethods {

	WebDriver driver;
	
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
		driver.findElement(By.xpath(locator)).sendKeys(value);
	}
	
	//click on given link-locator value
	public void click(String locator){
		driver.findElement(By.xpath(locator)).click();
	}
	
}
