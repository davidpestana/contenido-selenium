package com.ejemplo.selenium;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import listeners.TraceListener;

public class Eventos {
	private static WebDriver driver;

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}

	@Before
	public void antesDeCadaTest() {
		driver = new ChromeDriver();
	}

	@Test
	public void testEventosWebDriver() {
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		TraceListener listener = new TraceListener();
		eventDriver.register(listener);
		
		eventDriver.get("https://demoqa.com/automation-practice-form");
		List<WebElement> checkboxes = eventDriver.findElements(By.cssSelector(".custom-control-input"));
		for (WebElement check : checkboxes) {
			if (!check.isSelected()) {
				check.click();
			}
		}
		WebElement searchTextBox = eventDriver.findElement(By.id("subjectsInput"));
		searchTextBox.clear();
		searchTextBox.sendKeys("Selenium");
		searchTextBox.submit();
		eventDriver.findElement(By.cssSelector("excepcion para que la capture el evento y realice una captura de pantalla"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
