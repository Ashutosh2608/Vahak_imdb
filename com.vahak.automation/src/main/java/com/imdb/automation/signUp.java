package com.imdb.automation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signUp {

	public static void details(WebDriver driver, Properties pr) {
		driver.findElement(By.xpath(pr.getProperty("SignIn_button"))).click();
		driver.findElement(By.xpath(pr.getProperty("Creat_Account_button"))).click();

		driver.findElement(By.id(pr.getProperty("Customer_Name"))).sendKeys(pr.getProperty("Name"));
		driver.findElement(By.id(pr.getProperty("Customer_email"))).sendKeys(pr.getProperty("emaid_id"));
		driver.findElement(By.id(pr.getProperty("Password"))).sendKeys(pr.getProperty("pass"));
		driver.findElement(By.id(pr.getProperty("Password_check"))).sendKeys(pr.getProperty("pass"));
		driver.findElement(By.id(pr.getProperty("continue_signup"))).click();

	}

}
