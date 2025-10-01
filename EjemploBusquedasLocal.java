package com.ejemplo.selenium;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class BusquedasDemo {
	private static WebDriver driver;

	

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}
	
	@Before
	public void antesDeCadaTest(){
		driver = new ChromeDriver();
		driver.get("http://localhost");
	    //driver.findElement(By.cssSelector(".btn-primary")).click();		
	}	
	
	@Test
	public void byId() {
		WebElement username = driver.findElement(By.id("input-user"));
		WebElement password = driver.findElement(By.id("input-pass"));
		assertNotNull(username);
		assertNotNull(password);
	}
	
	@Test
	public void byName() {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		assertNotNull(username);
		assertNotNull(password);
	}
	
	
	@Test
	public void byClassName() {
		WebElement username = driver.findElement(By.className("in-user"));
		WebElement password = driver.findElement(By.className("in-pass"));
		assertNotNull(username);
		assertNotNull(password);
	}
	
	
	@Test
	public void byTagNameGet2() {
		List<WebElement> labels = driver.findElements(By.tagName("label"));
		
		for (WebElement label: labels) {
			assertNotNull(label);
		}

		assertEquals(labels.size(),2);
	}	
	

	@After
	public void tearDown() {
		driver.quit();
	}	
}
