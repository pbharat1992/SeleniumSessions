package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChromeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\\\\\\\selenium\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		// chrome version should be greater than 59 on mac and 60 on windows
		// window-size=1400,800==mandatory
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		System.out.println("login page=" + driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("pbharat1992");
		driver.findElement(By.name("password")).sendKeys("P@bharat3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		System.out.println("home page=" + driver.getTitle());

	}

}
