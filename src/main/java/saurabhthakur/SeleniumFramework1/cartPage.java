package saurabhthakur.SeleniumFramework1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponent.Abstractcomponent;

public class cartPage extends Abstractcomponent{
	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css =".cartSection h3")
	List<WebElement> cartProducts;
	
	
	public Boolean varifyProductDisplay(String productName) {
		
		 Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));

		    return match;
		
	}
	
	public Checkout checkouts() {
		checkout.click();
		return new Checkout(driver);
	}
	
}
