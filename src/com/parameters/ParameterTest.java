package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver driver;

	@Test
	@Parameters({ "env", "browser", "url", "emailId" })
	public void yahooLoginTest(String env, String browser, String url, String emailId) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		driver.get(url);

		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys(emailId); // enter
																						// username
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click(); // click
																			// on
																			// next
																			// button
		// you can do two ways to read the environmental variables from the machine
		// 1 using parameters annotations concept through testng concept(we have to
		// create testng.xml file and give the env variables in that file using
		// parameter attribute)
		// 2 config.properties file( create config.properties file and import the env
		// variables using FileInputStream class)
	}

}
