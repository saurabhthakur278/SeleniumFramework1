package saurabhthakur.SeleniumFramework1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.Abstractcomponent;

public class landngPage extends Abstractcomponent{
	WebDriver driver;
	
	public landngPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
		
	@FindBy(id="login")
	WebElement loginBtn;
	
	
	public productcatalog ligin(String email, String pass) {
		username.sendKeys(email);
		password.sendKeys(pass);
		loginBtn.click();
		 productcatalog pc=new productcatalog(driver);
		 return pc;
		
	}
			public void goTo() {
	driver.get("https://rahulshettyacademy.com/client/");
			}		
}
