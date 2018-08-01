package com.Selinium.Sessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// page loading
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// for all the elements
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=DkLLWqzqLIWjX6iWlLAF");
		// get the total count of links on that page
		// get the text of the link in that page
		// all the links are represented by <a> html tag
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		// size of the links
		System.out.println(linklist.size());

		// display all the links

		for (int i = 0; i < linklist.size(); i++) {
			String linkText = linklist.get(i).getText();
			System.out.println(linkText);
		}

	}
}
