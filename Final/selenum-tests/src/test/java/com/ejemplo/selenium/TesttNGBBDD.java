package com.ejemplo.selenium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import utils.DBUtils;

public class TesttNGBBDD {
	private static WebDriver driver;
	
	
	@DataProvider(name= "data1")
	  	public Object[][] getDataFromTestSumas() {
		return DBUtils.leerSumas().toArray(new Object[0][0]);
	}	
	
	@BeforeClass
		public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}
	
	@BeforeMethod
	public void antesDeCadaTest(){
		driver = new ChromeDriver();
		driver.get("http://localhost/data.html");
	}	
	
	@Test(dataProvider="data1")
	public void testAlgo(String num1, String num2, String res) {
		WebElement campo1 = driver.findElement(By.id("n1"));
		WebElement campo2 = driver.findElement(By.id("n2"));
		campo1.clear();
		campo2.clear();
		campo1.sendKeys(num1);
		campo2.sendKeys(num2);
		WebElement btnSuma = driver.findElement(By.id("btn-suma"));
		btnSuma.click();
		WebElement campoRes = driver.findElement(By.id("res"));
		Assert.assertEquals(campoRes.getText(), res);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
}
