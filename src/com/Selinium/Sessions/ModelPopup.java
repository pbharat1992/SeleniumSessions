package com.Selinium.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ModelPopup{

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.freecrm.com/index.html");

		driver.findElement(By.xpath("//input[@name='username' and @type = 'text']")).sendKeys("pbharat1992");
		driver.findElement(By.xpath("//input[@name='password' and @type = 'password']")).sendKeys("P@bharat3");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Login' and @type='submit']")).click();
		driver.switchTo().frame("mainpanel");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]")))
		.build().perform();
		
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		
		driver.findElement(By.xpath("//input[@value='Login' and @type='submit']")).click();
		
		
	}

}
