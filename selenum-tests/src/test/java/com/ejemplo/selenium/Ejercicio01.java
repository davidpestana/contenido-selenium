package com.ejemplo.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import java.util.List;


public class Ejercicio01 {
	private static WebDriver driver;

	@BeforeClass
	public static void alComienzo() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/web-drivers/chromedriver");
	}
	
	@Before
	public void antesDeCadaTest(){
		driver = new ChromeDriver();
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

	}	
	
	@Test
	public void entrenarFindElements() {
		WebElement portada = driver.findElement(By.id("n-mainpage-description"))
					.findElement(By.tagName("a"))
					.findElement(By.tagName("span"));
		//WebElement portal = driver.findElement(By.id("n-portal"));
		//WebElement ayuda = driver.findElement(By.id("n-help"));
		//WebElement donaciones = driver.findElement(By.id("n-sitesupport"));
		assertEquals("Portada", portada.getAttribute("innerHTML"));
		//assertEquals(portal.getText(), "Portal de la comunidad");
		//assertEquals(ayuda.getText(), "Ayuda");
		//assertEquals(donaciones.getText(), "Donaciones")		
	}
	
	@Test
	public void entrenarBusquedaEnlaces() {
		
		List<WebElement> enlaces = driver.findElement(By.id("p-navigation")).findElements(By.tagName("li"));
		String [] titles = {"Visitar la página principal [alt-z]", "titulo2","titulo3", "titulo4","titulo5", "titulo6", "titulo7", "titulo8"};
		int index = 0;
		for (WebElement enlace: enlaces) {
			enlace.getAttribute("id");
			assertEquals(titles[index++],enlace.findElement(By.tagName("a")).getAttribute("title"));
		}
		assertEquals(enlaces.size(), 8);
	
	}
	
	#ca-view
	
	#ca-view > a > span
	
	//*[@id="n-mainpage-description"]/a/span
	/html/body/div[1]/header/div[1]/nav/div/div/div/div/div[2]/div[2]/ul/li[1]/a/span
	
	//*[@id="ca-view"]/a/span
	/html/body/div[2]/div/div[3]/main/div[1]/div/div[2]/nav[1]/div/div/ul/li[1]
	/html/body/div[2]/div/div[3]/main/div[1]/div/div[2]/nav[1]/div/div/ul/li[1]/a/span
	
	findElement(By.ById("ca-view")).
	
	findElement(By.xpath("//*[@id="ca-view"]/a/span"));
	
	html.scroll-smooth.light body div#__nuxt div#app nav#desktop.hidden.md:flex.h-[var(--nh)] div.section-headers.w-full.h-full.pe-4.flex.justify-end.text-white div.section-header.relative.flex.items-center.h-full.rounded-2xl.hover:bg-fp-blue-700/50.bg-clip-padding.border-4.border-transparent input#button-downloads-b.section-button-b.absolute.left-0.w-full.top-0.h-full.rounded-2xl.block.bg-fp-darkblue-700.opacity-0

	#button-downloads-b
	
	
	html.scroll-smooth.light body div#__nuxt div#app nav#desktop.hidden.md:flex.h-[var(--nh)] div.section-headers.w-full.h-full.pe-4.flex.justify-end.text-white div.section-header.relative.flex.items-center.h-full.rounded-2xl.hover:bg-fp-blue-700/50.bg-clip-padding.border-4.border-transparent input#button-downloads-b.section-button-b.absolute.left-0.w-full.top-0.h-full.rounded-2xl.block.bg-fp-darkblue-700.opacity-0
	@Test
	public void checkTitle() {
		driver.get("https://www.google.com");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}	
}
