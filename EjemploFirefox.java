package com.ejemplo.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EjemploFirefox {
	private static WebDriver driver;

	

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/web-drivers/geckodriver");
	}
	
	@Before
	public void antesDeCadaTest(){
		driver = new FirefoxDriver();
	}	
	
	@Test
	public void goToGoogle() {
		driver.get("https://www.google.com");
	}
	
	@Test
	public void checkTitle() {
		driver.get("https://www.google.com");
	}
	
	
	
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}	
	
	
}