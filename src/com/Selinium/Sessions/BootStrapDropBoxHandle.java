package com.Selinium.Sessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropBoxHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch the chrome driver
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1");
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-info btn-sm dropdown-toggle')]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu')]//li//label"));
		System.out.println(list.size());
		// for selecting all the checkboxes in dropdown in bootstrap
		/*
		 * for(int i=0;i<list.size();i++) { System.out.println(list.get(i).getText());
		 * list.get(i).click();
		 */
		// for selecting single element
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("JavaScript")) {
				list.get(i).click();
				break;
			}
			// if already selected use isSelected method it is available in
			// ElementVisibilityTest program

		}
	}
}