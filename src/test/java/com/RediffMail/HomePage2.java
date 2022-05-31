package com.RediffMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePage2 {
	
	public static WebDriver driver;
	
	public HomePage2(WebDriver driver) {
		this.driver = driver;
	}
	
	By signInLink = By.linkText("Sign in");
	
  @Test
  public void clickOnSignInLink() {
	  driver.findElement(signInLink).click();
  }
}
