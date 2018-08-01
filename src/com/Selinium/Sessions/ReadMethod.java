package com.Selinium.Sessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadMethod {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"D:\\eclipse oxyzen\\eclipse\\CHARI\\SeliniumSessions\\src\\com\\Selinium\\Sessions\\config properties");
		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		String url = prop.getProperty("url");
		System.out.println(prop.getProperty("url"));
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\\\selenium\\\\chromedriver_win32\\\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
	}
}
