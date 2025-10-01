package com.ejemplo.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploChrome {
	private static WebDriver driver;

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}
	
	@Before
	public void antesDeCadaTest(){
		driver = new ChromeDriver();
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