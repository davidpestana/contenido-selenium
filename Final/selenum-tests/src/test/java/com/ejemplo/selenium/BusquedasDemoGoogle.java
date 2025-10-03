package com.ejemplo.selenium;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class BusquedasDemoGoogle {
	private static WebDriver driver;

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}
	
	@Before
	public void antesDeCadaTest(){
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}	

	
	@Test
	public void byLinkText() {
		WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
		assertEquals(gmailLink.getAttribute("href"),"https://mail.google.com/mail/&ogbl");
	}
	
	
	@Test
	public void byPartialLinkText() {
		WebElement gmailLink = driver.findElement(By.partialLinkText("ail"));
		assertEquals(gmailLink.getAttribute("href"),"https://mail.google.com/mail/&ogbl");
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}	
}
