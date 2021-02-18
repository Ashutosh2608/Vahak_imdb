package com.imdb.automation;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMovies {

	public static void movie(WebDriver driver, Properties pr) {
	

		driver.findElement(By.xpath(pr.getProperty("Menu"))).click();

		driver.findElement(By.linkText(pr.getProperty("Top_Movies"))).click();

		Select sl = new Select(driver.findElement(By.id(pr.getProperty("Sort_option"))));

		sl.selectByVisibleText(pr.getProperty("Sort_value"));

		List<WebElement> Movie = driver.findElements(By.tagName(pr.getProperty("table_tag")));

		for (int i = 0; i <= Movie.size() - 1; i++) {
			if (i == Movie.size() - 1) {

				driver.findElement(By.xpath(pr.getProperty("table_row") + i + pr.getProperty("table_column"))).click();
			}

		}

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr.getProperty("Date_Year"))));

		String date = driver.findElement(By.xpath(pr.getProperty("Date_Year"))).getText();

		System.out.println(date);
	}

}
