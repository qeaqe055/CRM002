package com.RediffMail;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMain {
	public WebDriver driver;
	
@Parameters("browser")	
  @BeforeClass(groups = {"Regression"})
  public void browserSetup(String browserName) throws IOException {
	 
	  if(browserName.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "DriverFiles//chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	
	  else if(browserName.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "DriverFiles//geckodriver.exe");
		  driver = new FirefoxDriver();
	  }
	  
	  FileReader fr = new FileReader("Configs//config.properties");
	  Properties p = new Properties();
	  p.load(fr);
	  
	  driver.get(p.getProperty("url"));
	  driver.manage().window().maximize();
  }

  @Test(groups= {"Regression"})
  public void verifyTitle() {
	  String expectedTitle = "Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
	  String actualTitle = driver.getTitle();
	  
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test(groups= {"Regression"})
  public void displayCurrentURL() {
	  String currentURL = driver.getCurrentUrl();
	  System.out.println(currentURL);
  }
  
  @Test(groups= {"Regression"})
  public void searchProduct() {
	  HomePage hp = new HomePage(driver);
	  hp.enterProductName();
	  hp.clickSearchButton();
  }
  
  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }
}
