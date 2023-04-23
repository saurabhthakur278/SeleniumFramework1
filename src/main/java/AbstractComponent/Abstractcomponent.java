
package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import saurabhthakur.SeleniumFramework1.cartPage;

public class Abstractcomponent 
{
	WebDriver driver;
	public Abstractcomponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	
	

	public void waituntilcomp(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

	}
	
	
 public void waitforeleDisappear(WebElement ele) throws InterruptedException {
		 
	 Thread.sleep(1000);
//	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//
//	 wait.until(ExpectedConditions.invisibilityOf(ele));
	 }
 
 
 public cartPage gotoCartPage() {
	 cartheader.click();
	 
	 cartPage cart =new cartPage(driver);
	 return cart;
 }

}
