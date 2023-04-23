package saurabhthakur.SeleniumFramework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.Abstractcomponent;

public class Checkout extends Abstractcomponent{
	WebDriver driver;
	public Checkout(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectIndia;
	
	By results=By.cssSelector(".ta-results");
	
	public void selectCountry(String enterCountry) {
		Actions a = new Actions(driver);
		
			    a.sendKeys(country, enterCountry).build().perform();
		
			    waituntilcomp(results);
			    
			    selectIndia.click();
		
			   

	}
	public confirmation SubmitOrder() {
		submit.click();
		 return new confirmation(driver);
	}
	
	
}
