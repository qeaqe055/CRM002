package com.RediffMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox") WebElement searchTextBox;
	@FindBy(id="nav-search-submit-button") WebElement searchButton;
	
	@Test
  public void enterProductName() {
		searchTextBox.sendKeys("Laptops");
  }

	public void clickSearchButton() {
		searchButton.click();
	}
	
}
