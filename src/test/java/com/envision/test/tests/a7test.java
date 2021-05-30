package com.envision.test.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.envision.core.browser.WebDriverManager;
import com.envision.core.components.ElementFinder;
import com.envision.core.properties.PropertiesLoader;


import junit.framework.Assert;

public class a7test {

	WebDriverManager webDriverManager;
	WebDriver driver;

	@BeforeSuite
	public void beforeAnythingElse() throws Exception {
		PropertiesLoader.readConfigurations();
	}

	@BeforeClass
	public void beforeClass() {
		webDriverManager = new WebDriverManager();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		webDriverManager.launchBrowser(PropertiesLoader.browser);
		driver = WebDriverManager.realWebDriver.get();
	}

	@Test
	public void doTest1() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertiesLoader.url);
		Thread.sleep(5000);

		WebElement element = ElementFinder.findElementByXpath("LoginPage1", "txtUsername");
		element.click();
		Thread.sleep(3000);

		element = ElementFinder.findElementByXpath("LoginPage1", "txtUsername");
		element.sendKeys("Admin");

		element = ElementFinder.findElementByXpath("LoginPage1", "txtPassword");
		element.sendKeys("admin123");
		
		element = ElementFinder.findElementByXpath("LoginPage1", "Submit");
		element.click();
		
		element = ElementFinder.findElementByXpath("HomePage1", "pimtab");
		element.click();
		
		element = ElementFinder.findElementByXpath("HomePage1", "pimaddemployee");
		element.click();

		element = ElementFinder.findElementByXpath("HomePage1", "firstname");
		element.click();
		Thread.sleep(3000);
		element.sendKeys("Jack");
		
		element = ElementFinder.findElementByXpath("HomePage1", "lastname");
		element.click();
		Thread.sleep(3000);
		element.sendKeys("Martin");

		element = ElementFinder.findElementByXpath("HomePage1", "employeeID");
		element.click();
		Thread.sleep(3000);
		element.clear();
		Thread.sleep(3000);
		element.sendKeys("3456");

		element = ElementFinder.findElementByXpath("HomePage1", "checkBox");
		element.click();

		element = ElementFinder.findElementByXpath("HomePage1", "username");
		element.click();
		Thread.sleep(3000);
		element.sendKeys("jackmartin");
		
		element = ElementFinder.findElementByXpath("HomePage1", "password");
		element.click();
		Thread.sleep(3000);
		element.sendKeys("MartinJack123");
		
		element = ElementFinder.findElementByXpath("HomePage1", "repassword");
		element.click();
		Thread.sleep(3000);
		element.sendKeys("MartinJack123");
		
		element = ElementFinder.findElementByXpath("HomePage1", "save");
		Thread.sleep(3000);
		element.click();
		
		element = ElementFinder.findElementByXpath("HomePage1", "welcome");
		element.click();
		element = ElementFinder.findElementByXpath("HomePage1", "logout");
		Thread.sleep(3000);
		element.click();
		
		element = ElementFinder.findElementByXpath("LoginPage1", "txtUsername");
		element.sendKeys("jackmartin");

		element = ElementFinder.findElementByXpath("LoginPage1", "txtPassword");
		element.sendKeys("MartinJack123");
		
		element = ElementFinder.findElementByXpath("LoginPage1", "Submit");
		element.click();
		
		element = ElementFinder.findElementByXpath("HomePage1", "welcome");
		element.click();
		element = ElementFinder.findElementByXpath("HomePage1", "logout");
		Thread.sleep(3000);
		element.click();
		
		Thread.sleep(5000);
	}

	@AfterMethod
	public void afterMethod() {
		webDriverManager.closeBrowser();
	}

}