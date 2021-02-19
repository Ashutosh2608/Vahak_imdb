package com.imdb.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationFramework {

	

	Properties pr;
	WebDriver driver;

	@BeforeSuite
	public void preload() throws IOException {
		pr = new Properties();
		FileInputStream fs = new FileInputStream("./OR.properties");
		pr.load(fs);

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");

		driver = new ChromeDriver();

	}

	@BeforeTest
	public void setBaseURL() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.navigate().to(pr.getProperty("URL"));

	}

	@Test

	public void signUp() {
		signUp.details(driver, pr);
	}

	@Test
	public void logIn() {
		signIn.logIn(driver, pr);
	}

	@Test
	public void topmovie() {
		TopMovies.movie(driver, pr);
	}

	@AfterTest
	public void endSession() {
		driver.quit();
	}

}
