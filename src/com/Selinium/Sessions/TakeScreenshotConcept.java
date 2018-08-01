package com.Selinium.Sessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeScreenshotConcept {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=DkLLWqzqLIWjX6iWlLAF");
		// take screen shot and store as a file
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the file to desired location using copyfile method
		Files.copy(src, new File("C:\\Users\\DELL\\Downloads\\google.png"));

	}

}
