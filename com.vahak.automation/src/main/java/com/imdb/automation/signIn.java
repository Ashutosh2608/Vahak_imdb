package com.imdb.automation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class signIn {

	public static void logIn(WebDriver driver, Properties pr) {

		driver.findElement(By.xpath(pr.getProperty("SignIn_button"))).click();

		driver.findElement(By.xpath(pr.getProperty("Login_IMDB"))).click();
		driver.findElement(By.id(pr.getProperty("Email"))).sendKeys(pr.getProperty("emaid_id"));
		driver.findElement(By.id(pr.getProperty("Pwd"))).sendKeys(pr.getProperty("pass"));
		driver.findElement(By.id(pr.getProperty("Submit"))).click();
	
		Assert.assertEquals("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows", driver.getTitle());

	}

}
