package com.ejemplo.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;



import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;


public class EjemploGrid {
	private static WebDriver driver;

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}
	
	@Before
	public void antesDeCadaTest() throws MalformedURLException{
		
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		URL gridUrl = URI.create("http://localhost:4444/wd/hub").toURL();
		driver = new RemoteWebDriver(gridUrl, options);
	}	
	
	@Test
	public void goToGoogle() {
		driver.get("https://www.google.com");
	}
	
	@Test
	public void checkTitle() {
		driver.get("https://www.google.com");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}	
}
