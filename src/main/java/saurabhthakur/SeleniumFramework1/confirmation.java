package saurabhthakur.SeleniumFramework1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.Abstractcomponent;

public class confirmation extends Abstractcomponent{

	WebDriver driver;
	public confirmation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmMessage;

	
	
	
	public String varificationmsg() {
		return confirmMessage.getText();
	}
	
	
	
	
	
}




