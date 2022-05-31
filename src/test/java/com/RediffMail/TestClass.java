package com.RediffMail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

	public static WebDriver driver;
	
	@BeforeClass
	public void driverSetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.rediffmail.com");
		driver.manage().window().maximize();	
	}
	
	@Test(priority=0)
  public void testHomePage() 	{
		HomePage2 hp = new HomePage2(driver);
		hp.clickOnSignInLink();
  }
	
	@Test(priority=1)
	public void testLoginPage() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.enterCredentials();
	}
	
	@AfterClass
	public void closeBrowser() {
		//driver.close();
	}
}
