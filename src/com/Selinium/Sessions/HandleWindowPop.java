package com.Selinium.Sessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// two types of popups
		// alerts-javascript popups-Alert API(accept,dismiss methods)
		// fileupload popups-browse button,attach button,anything like similar
		// buttons(type-file,sendKeys(path))
		// browser window-Advertisement window-window handler API-getWindowhandler())
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[@class='black']")).click();
		Thread.sleep(2000);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id" + parentWindowId);
		String childWindowId = it.next();
		System.out.println("child window id" + childWindowId);
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);
		System.out.println("child Window popup title" + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("parent window title" + driver.getTitle());

	}

}
