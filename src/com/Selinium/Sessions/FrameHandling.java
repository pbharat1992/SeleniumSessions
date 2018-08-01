package com.Selinium.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch the chrome driver
		// driver.manage().window().maximize();//maximize window
		// driver.manage().deleteAllCookies();// delete all cookies
		// dynamic wait
		// driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);

		// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("pbharat1992");
		driver.findElement(By.name("password")).sendKeys("p@bharat3");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		/*
		 * Thread.sleep(3000); driver.switchTo().frame("mainpanel"); Thread.sleep(2000);
		 * 
		 * driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		 */

	}

}
