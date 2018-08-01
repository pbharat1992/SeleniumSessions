package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdownbox {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/"); // enter url

		driver.findElement(By.xpath("//*[@id=\"day\"]")).sendKeys("11");
		driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("Aug");
		driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("1992");

	}
}
