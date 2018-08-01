package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// for all the elements

		driver.get("https://www.freecrm.com/index.html");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("pbharat1992");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("P@bharat3");

	}

}
