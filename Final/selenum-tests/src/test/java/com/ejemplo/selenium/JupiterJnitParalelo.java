package com.ejemplo.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


@RunWith(Parameterized.class)
public class JupiterJnitParalelo {
	WebDriver driver;
	private String browser;

	
	@Parameterized.Parameters
	public static List<Object[]> data() {
		
		return Arrays.asList(new Object[][] {
			{"chrome"},
			{"chrome"},
			{"chrome"},
			{"chrome"},
			{"chrome"},
			{"chrome"},
			{"firefox"}
		});
	}
	
	public JupiterJnitParalelo(String browser) {
		this.browser = browser;
	}
	

	@Before
	public void setup() throws Exception {
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), new ChromeOptions());
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), new FirefoxOptions());
		}
		driver.get("https://www.google.com");
	}
	
	
	@Test
	public void noQuedanTareasTrasLimpiarLaLista() {
		List<WebElement> enlaces = driver.findElements(By.tagName("a"));
		assertTrue(enlaces.size() > 0);
	}
	

}
