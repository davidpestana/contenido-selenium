package com.ejemplo.selenium;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Testa {
	WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeMethod	
	public void setup(String browser) throws Exception {
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), new ChromeOptions());
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), new FirefoxOptions());
		}
		driver.get("https://www.google.com");
	}
	
	@Test
	public void testUno() {
		List<WebElement> enlaces = driver.findElements(By.tagName("a"));		
		Assert.assertTrue(enlaces.size() > 0);
	}
	
}
