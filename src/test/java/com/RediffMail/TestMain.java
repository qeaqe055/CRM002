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
  @BeforeClass(groups= {"SmokeTest"})
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

  @Test(priority=0, groups={"SmokeTest"})
  public void verifyTitle() {
	  String expectedTitle = "Amazon.com. Spend less. Smile more.";
	  String actualTitle = driver.getTitle();
	  //System.out.println(actualTitle);
	  Assert.assertEquals(expectedTitle, actualTitle);
  }
  
  @Test(priority=1, groups= {"RegressionTest"})
  public void displayCurrentURL() {
	  String currentURL = driver.getCurrentUrl();
	  System.out.println(currentURL);
  }
  
  @Test(priority=2, groups= {"RegressionTest"})
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
