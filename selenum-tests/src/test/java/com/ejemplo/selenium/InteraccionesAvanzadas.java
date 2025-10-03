package com.ejemplo.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InteraccionesAvanzadas {
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
	  public void testDoubleClick() {
	  driver.get("https://demoqa.com/buttons");
	  WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
	  Actions builder = new Actions(driver);
	  builder.doubleClick(doubleClickBtn).perform();
	  WebElement mensajeDoubleClick = driver.findElement(By.id("doubleClickMessage"));
	  assertTrue(mensajeDoubleClick.isDisplayed());
	}
	
	
	@Test
	  public void testDragAndDrop() {
	  driver.get("https://demoqa.com/droppable");
	  WebElement source = driver.findElement(By.id("draggable"));
	  WebElement target = driver.findElement(By.id("droppable"));
	  Actions builder = new Actions(driver);
	  
	  //builder.clickAndHold(source).moveByOffset(150, 100).release().perform();
	  
	  builder.dragAndDrop(source, target).perform();
	  assertEquals(target.getText(), "Dropped!");
	 }
	
	@Test
	  public void comprobarFuncionSaludar() {
	  driver.get("http://localhost/alert.html");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("saludar();");
	  Alert alert = driver.switchTo().alert();
	  assertEquals(alert.getText(), "Hola mundo!!!");
	  alert.accept();
	}	
	
	  @Test
	  public void testScreenshots() throws IOException {
		  driver.get("https://demoqa.com/droppable");
		  WebElement source = driver.findElement(By.id("draggable"));
		  WebElement target = driver.findElement(By.id("droppable"));
		  File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  
		  FileUtils.copyFile(srcFile, new File("src/test/resources/screenshots/beforeDragAndDrop.png"));
		  
		  
		  Actions builder = new Actions(driver);
		  builder.dragAndDrop(source, target).perform();
		  assertEquals(target.getText(), "Dropped!");
		  srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(srcFile, new File("src/test/resources/screenshots/afterDragAndDrop.png"));
	  }	
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}	
}
