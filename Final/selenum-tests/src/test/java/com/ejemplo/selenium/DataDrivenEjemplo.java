package com.ejemplo.selenium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class DataDrivenEjemplo {
	private static WebDriver driver;
	private String num1;
	private String num2;
	private String res;
	
	
	public DataDrivenEjemplo(String num1, String num2, String res) {
		this.num1 = num1;
		this.num2 = num2;
		this.res = res;
	}	
	
	 
	public static List<String[]> testData() {
		return Arrays.asList(
				new String[][] { { "1", "2", "3" }, { "3", "10", "13" }, { "4", "6", "10" }, { "8", "1", "8" } });
	}
	
	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] { { "1.1", "2", "3.1" }, { "3,1", "10", "1.3" }, { "4", "6", "10" }, { "8", "1", "9" } });
	}


	

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}

	@Before
	public void antesDeCadaTest() {
		driver = new ChromeDriver();
		driver.get("http://localhost/data.html");
	}

	@Test
	public void testSuma() {
		WebElement campo1 = driver.findElement(By.id("n1"));
		WebElement campo2 = driver.findElement(By.id("n2"));
		campo1.clear();
		campo2.clear();
		campo1.sendKeys(num1);
		campo2.sendKeys(num2);
		WebElement btnSuma = driver.findElement(By.id("btn-suma"));
		btnSuma.click();
		WebElement campoRes = driver.findElement(By.id("res"));
		assertEquals(campoRes.getText(), res);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
