package com.ejemplo.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncWait {
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
	public void testWebDriverWait() {
	  driver.get("http://localhost/async.html");
	  WebDriverWait wait = new WebDriverWait(driver, 8);
	  WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btn-1")));
	  button.click();
	}
	

	
	@After
	public void tearDown() {
		driver.quit();
	}	
}
