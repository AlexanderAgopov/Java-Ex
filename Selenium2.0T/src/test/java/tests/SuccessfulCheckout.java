package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulCheckout {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	@Test
	public void test() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.partialLinkText("Add to cart")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("layer_cart")));
		WebElement layerCart = driver.findElement(By.id("layer_cart"));
		WebElement buttonContainer = driver.findElement(By.className("button-container"));
		buttonContainer.findElement(By.xpath("//a[.='Proceed to checkout']")).click();
		// wait.until(ExpectedConditions.titleContains("account"));
		driver.get("http://automationpractice.com/index.php?controller=order");
		driver.findElement(By.linkText("http://automationpr actice.com/index.php?controller=order&step=1")).click();
		// wait.until(ExpectedConditions.titleContains("account"));
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("Z@z.Z");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("!@#a2");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.className("button btn btn-default button-medium")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.className("button btn btn-default button-medium")).click();
		driver.findElement(By.partialLinkText("bank")).click();
		driver.findElement(By.linkText("I confirm my order")).click();
		WebElement orderConfirmed = driver
				.findElement(By.xpath("//*[contains(text(),'" + "Your order on My Store is complete." + "')]"));
		assertEquals("Your order on My Store is complete.", orderConfirmed);

	}

}
