package com.Selinium.Sessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariWebDriver {
	public static void main(String[] args) {

		WebDriver driver = new SafariDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();

	}
}
