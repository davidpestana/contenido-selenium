package com.ejemplo.selenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploChrome2 {
	private static WebDriver driver;

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}
	
	@Before
	public void antesDeCadaTest(){
		driver = new ChromeDriver();		
		driver.get("https://todomvc.com/examples/vue/dist/#/");
		WebElement box = driver.findElement(By.cssSelector(".new-todo"));
		for(int i = 1; i <= 5 ; i++) {
			box.sendKeys("tarea " + i);
			box.sendKeys(Keys.RETURN);
		}		
	}	
	
	@Test
	public void primerCheckNoSeleccionado() {
		WebElement firstCheckBox = driver.findElement(By.cssSelector("li:nth-child(1) > div.view > input"));
		assertFalse(firstCheckBox.isSelected());
	}
	
	
	@Test 
	public void todosLosChecksSeleccionadosTrasSeleccionar() {
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input.toggle[type='checkbox']"));
		for (WebElement elem : checkBoxes) {
			if (!elem.isSelected()) {
				elem.click();
			}
		}
		for (WebElement elem : checkBoxes) {
			assertTrue(elem.isSelected());
		}
	}
	

	
	@After
	public void tearDown() {
		driver.quit();
	}	
}
