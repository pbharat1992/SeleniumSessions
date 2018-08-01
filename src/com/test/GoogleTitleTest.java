package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	WebDriver driver;

	// 1//4//7
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch the chrome driver
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("");
	}

	// 2
	@Test()
	@Parameters({ "url", "emailid" })
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google123", "title is not matched");

		// assert--is used for validation purpose for eg we use google today next day we
		// open it shows facebook so that we use assertion to validate purpose
	}

	@Test()
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//*[@id=\"hplogo\"]/a/img")).isDisplayed();
		Assert.assertTrue(b);
		Assert.assertEquals(b, true);

	}

	// 3//6//7
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
