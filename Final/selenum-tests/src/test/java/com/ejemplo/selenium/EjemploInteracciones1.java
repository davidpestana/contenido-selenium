package com.ejemplo.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;

public class EjemploInteracciones1 {
	private static WebDriver driver;

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}
	
	@Before
	public void antesDeCadaTest(){
		driver = new ChromeDriver();
		driver.get("http://localhost/interacciones.html");
	}	
	@Test
	 public void getCssValueAndAttribute() {
		 
		 WebElement mensaje = driver.findElement(By.id("mensaje"));
		 assertEquals(mensaje.getAttribute("value"), "Hola mundo!!!");
		 assertEquals(mensaje.getCssValue("width"), "200px");
		 mensaje.clear();
		 mensaje.sendKeys("adios mundo!!!");
		 assertEquals(mensaje.getAttribute("value"), "adios mundo!!!");
	 }
	@After
	public void tearDown() {
		driver.quit();
	}	
}
