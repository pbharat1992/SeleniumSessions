package com.Selinium.Sessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	public static void main(String[] args) {
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\selenium\\geckodriver-v0.20.0-win64\\geckodriver.exe"); WebDriver
		 * driver=new FirefoxDriver();//launch the firefox driver
		 */
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch the chrome driver
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		// validation point
		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}
		System.out.println(driver.getCurrentUrl());

	}
}