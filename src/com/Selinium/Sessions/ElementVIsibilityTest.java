package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVIsibilityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\\\\\selenium\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		// 1.isDisplayed() method:aplicable for all the elements
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println(b1);// true

		// 2.isEnabled() method
		boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b2);// false

		// select I Agree checkbox
		driver.findElement(By.name("agreeTerms")).click();// submit button is enabled now
		boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b3);// true

		// 3.isSelected() method:only applicable for checkbox,dropdown,radiobutton
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b4);// true

		// 4.deselect the checkbox
		driver.findElement(By.name("agreeTerms")).click();
		boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b5);// false

	}

}
