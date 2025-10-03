package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MvcPage {
	public String url = "https://todomvc.com/examples/vue/dist/#/";
	private WebDriver driver;
	
	@FindBy(className = "new-todo")
	  private WebElement newTodo;


	public MvcPage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(this.driver, this);
	}
	
	public void createTodo(String text) {
		  this.newTodo.sendKeys(text);
		  this.newTodo.sendKeys(Keys.ENTER);
	}
	
}
