package com.RediffMail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPage {

	public static WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By loginId = By.id("login1");
	By passwd = By.id("password");
	By signInButton = By.name("proceed");

	
	@Test
  public void enterCredentials() throws IOException {
		
		FileInputStream fi = new FileInputStream("c:\\TestData\\TestData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow r1 = sheet.getRow(1);
		XSSFCell c0 = r1.getCell(4);
		XSSFCell c1 = r1.getCell(5);
		
		XSSFRow r2 = sheet.getRow(2);
		XSSFCell c2 = r2.getCell(0);
		XSSFCell c3 = r2.getCell(1);
		
		XSSFRow r0 = sheet.getRow(0);
		XSSFCell c4 = r0.getCell(0);
		XSSFCell c5 = r0.getCell(1);
		
		driver.findElement(loginId).sendKeys(c0.toString());
		
		driver.findElement(passwd).sendKeys(c1.toString());
		
		driver.findElement(signInButton).click();
	}
}
