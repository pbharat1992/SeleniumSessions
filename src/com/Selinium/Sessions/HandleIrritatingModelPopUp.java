package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleIrritatingModelPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\\\\\\\selenium\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		// chrome version should be greater than 59 on mac and 60 on windows
		// window-size=1400,800==mandatory

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
		driver.switchTo().frame("intercom-borderless-frame");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]")))
				.build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		driver.findElement(By.xpath("//input[@value='Login' and @type='submit']")).click();
		System.out.println("home page=" + driver.getTitle());

	}

}
