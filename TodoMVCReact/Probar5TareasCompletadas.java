package com.ejemplo.selenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


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

public class Probar5TareasCompletadas {
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
		
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input.toggle[type='checkbox']"));
		for (WebElement elem : checkBoxes) {
			if (!elem.isSelected()) {
				elem.click();
			}
		}
	}	
	
	@Test
	public void noQuedanTareasTrasLimpiarLaLista() {
		WebElement clearCompleted = driver.findElement(By.cssSelector("button.clear-completed"));
		clearCompleted.click();
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input.toggle[type='checkbox']"));
		assertEquals(0,checkBoxes.size());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}	
}