package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// for all the elements
		driver.get("https://www.facebook.com/");
		clickOn(driver, driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")), 20);// for login
		clickOn(driver, driver.findElement(By.xpath("//*[@id=\"reg_pages_msg\"]/a")), 10);// for create page link
	}

	private static void clickOn(WebDriver driver, WebElement locater, int timeout) {
		// TODO Auto-generated method stub

		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locater));
		locater.click();

	}

}
