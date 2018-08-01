package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocaterConcept {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com"); // enter url
		// 1.xpath second to prefer
		// absolute xpath should not be used----
		// only relative xpath should be used----for eg (//*[@id=\"firstname\"]) other
		// than like this we should not use

		// driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Tom");
		// driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Peter");

		// 2.id first to prefer
		// driver.findElement(By.id("email")).sendKeys("Tom");
		// driver.findElement(By.id("pass")).sendKeys("Peter");

		// 3.name: third to prefer
		// driver.findElement(By.name("")).sendKeys("Tom");
		driver.findElement(By.name("firstname")).sendKeys("Peter");// (for text boxes)

		// 4.Link Text(only for links)

		// driver.findElement(By.id("u_0_2")).click();

		// 5.partial link text(not recommonded) only for interview purpose(for long
		// links) but we have to use link text for long links by using shortcut names
		// driver.findElement(By.partialLinkText("How to pick")).click();

		// 6.CSS selector second to prefer
		// if id is there ----put #(id)
		// if class is there----- put .classname
		// driver.findElement(By.cssSelector("#u_0_n")).sendKeys("Tom");//for paragraphs
		// it is good to use

		// 7:class name(not recommonded) fourth to prefer
		// driver.findElement(By.className("inputtext _58mg _5dba
		// _2ph-")).sendKeys("bharat");

	}

}
