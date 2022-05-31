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
	//Location of Search Text Box
	@FindBy(id="twotabsearchtextbox") WebElement searchTextBox;
	
	//Location of Search button
	@FindBy(id="nav-search-submit-button") WebElement searchButton;
	
	@Test
	//This method will search the product
	public void enterProductName() {
		searchTextBox.sendKeys("Laptops");
  }

	//This method used to click on search button
	public void clickSearchButton() {
		searchButton.click();
	}
	
}
