package saurabhthakur.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import saurabhthakur.SeleniumFramework1.landngPage;

public class BaseTest {
	
	public WebDriver driver;
	public landngPage lp;
	public WebDriver initialization() throws IOException {
	
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//saurabhthakur//resourses//GlobalData.properties");
		
		prop.load(fis);
		String BrowserName=prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		
		}
		else if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		return driver;
	}
	@BeforeMethod
public landngPage launchApp() throws IOException {
	driver=initialization();
	 lp=new landngPage(driver);
	lp.goTo();
	 driver.manage().window().fullscreen();
	 return lp;
	
	}
	@AfterMethod
	public void teaddown() {
		driver.close();
	}
	
	
	public String ScreenshotDemo(String testcaseName , WebDriver driver) throws IOException {
		
		 TakesScreenshot ts = (TakesScreenshot) driver;
		File sourse= ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(sourse, file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	        
	}
	
	
	
	
	
	
	
	
	

}
