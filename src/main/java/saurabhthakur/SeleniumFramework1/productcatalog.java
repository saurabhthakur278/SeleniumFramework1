package saurabhthakur.SeleniumFramework1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.Abstractcomponent;

public class productcatalog extends Abstractcomponent{
	
	WebDriver driver;
	public productcatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));
	
	@FindBy(xpath ="//div[contains(@class, 'mb-3')]")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	 
	By proct=By.cssSelector(".mb-3"); //  xpath("//div[contains(@class, 'mb-3')");
	By AddTocart=By.cssSelector(".card-body button:last-of-type");
	By toast=By.cssSelector("#toast-container");
	
	public List<WebElement> getproductList() {
		
		waituntilcomp(proct);
		return products;
		
	}
	 public WebElement getproductByName(String productName) {
		 WebElement prod = getproductList().stream().filter(product->
		 
		 	product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals(productName)).findFirst().orElse(null);

		 return prod;
	 }
	 public void addprodtoCart(String productName) throws InterruptedException {
		 WebElement prod=getproductByName(productName);
		 prod.findElement(AddTocart).click();
		 waituntilcomp(toast);
		 waitforeleDisappear(spinner);
	 }
	
	


}