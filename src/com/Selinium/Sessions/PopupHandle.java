package com.Selinium.Sessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupHandle {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); // enter url

		driver.findElement(By.name("proceed")).click();// click go button

		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		String text = alert.getText();
		if (text.equals("please enter username")) {
			System.out.println("correct alert message");
		} else {
			System.out.println("incorrect alert message");
		}
		alert.accept();// click on ok
		// alert.dismiss();//cancel button is there

	}

}
