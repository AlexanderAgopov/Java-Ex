package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium2Example {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("CSKA");
		element.submit();
		System.out.println("Page title is: " + driver.getTitle());

		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 5 seconds
		
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cska");
			}
		});
		

		// Should see: "CSKA - Google Search"
		System.out.println("Page title is: " + driver.getTitle());
		System.out.println("The URL is: " + driver.getCurrentUrl());
		driver.navigate().to("http://automationpractice.com/index.php");
		System.out.println("The URL is: " + driver.getCurrentUrl());


		// Close the browser
		driver.quit();

	}

}
