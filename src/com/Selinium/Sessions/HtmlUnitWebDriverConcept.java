package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitWebDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\\\\\selenium\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		// WebDriver driver=new ChromeDriver();
		// htmlunitdriver is not available in selenium 3.x version
		// htlunitdriver---to use this concept,we have to download htmlunitdriver JAR
		// file.
		// advantages
		// 1.testing is happening behind the scene--no browser is launched
		// 2.very fast---execution test cases ---very fast --peroformance of the script
		// not suitable for Actions class---user
		// actions----mousemovement,doubleclick,drag and drop
		// GhostDriver-headless browser
		// --HtmlUnit driver---java
		// --Phantomjs--javascript

		WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		System.out.println("before login" + driver.getTitle());
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("pbharat1992");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("p@bharat3");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println("after login" + driver.getTitle());
	}

}
