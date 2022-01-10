package com.revature.features;

import java.io.File;

import java.io.File;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LogInStepImpl {
	
	public WebDriver driver;
	
	
	// instance block that runs
	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
	}
	
	@FindBy(id="loginBtn")
	private WebElement loginBtn;
	@FindBy(id="username")
	private WebElement usernameInput;
	@FindBy(id="password")
	private WebElement passwordInput;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    driver.get("F:\\Revature\\project-1\\p1-trms-Gamygams1234\\trms-front\\index.html");
	    driver.findElement(By.tagName("button")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("input"), 1));
		
	}

	@When("the user enters {string} and {string} to log in")
	public void the_user_enters_and_to_log_in(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
	}

	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
		loginBtn.click();
	}

	@Then(" the page includes a Log Out Button")
	public void the_page_says_welcome(String username) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("log-out"), 1));
	}

	@Then("the page says Password or username was invalid.")
	public void the_page_says_incorrect_credentials() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("invalid-password"), 1));
	}
}
