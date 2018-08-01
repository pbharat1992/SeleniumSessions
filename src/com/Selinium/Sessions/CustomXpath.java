package com.Selinium.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.com/");

		// drawback of absolute xpath
		// performance testing
		// not reliable
		// can be change at any time
		// driver.findElement(By.xpath("//input[@class='gh-tb
		// ui-autocomplete-input']")).sendKeys("Java");
		// driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java");
		// driver.findElement(By.xpath("//input[contains(class,'gh-tb
		// ui-autocomplete-input']")).sendKeys("Java");
		// dynamic id:input
		// id=_test_123
		// By.id="test-123")
		// startswith
		// id=test_456
		// id=test_7890_test_test
		// endswith
		// id=text_
		// id=1234_test_t
		// id=123456_test_t
		// id=6789_test_t

		// driver.findElement(By.xpath("//input[contains(@id,'gh-ac')]")).sendKeys("Test");
		// driver.findElement(By.xpath("//input[startswith(@id,'gh-ac')]")).sendKeys("Test");
		driver.findElement(By.xpath("//input[endswith(@id,'-ac')]")).sendKeys("Java");
		// for links custom xpath
		// all the links represented with <a> html tag
		// driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

	}

}
