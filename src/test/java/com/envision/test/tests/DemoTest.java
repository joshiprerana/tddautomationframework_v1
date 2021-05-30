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

public class DemoTest {

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
		WebElement element = ElementFinder.findElementByXpath("HomePage", "lnk_SignIn");
		element.click();
		Thread.sleep(5000);
		element = ElementFinder.findElementByXpath("LoginPage", "tbx_Username");
		element.sendKeys("Hey@abc.com");
		element = ElementFinder.findElementByXpath("LoginPage", "tbx_Password");
		element.sendKeys("Testing@123");
		element = ElementFinder.findElementByXpath("LoginPage", "btn_Submit");
		element.click();
		Thread.sleep(10000);
	}

	@AfterMethod
	public void afterMethod() {
		webDriverManager.closeBrowser();
	}

}