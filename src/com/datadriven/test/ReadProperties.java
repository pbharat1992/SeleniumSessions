package com.datadriven.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class ReadProperties {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\eclipse oxyzen\\eclipse\\CHARI\\SeliniumSessions"
				+ "\\src\\com\\datadriven\\test\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("browser"));
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
        	System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        	driver=new ChromeDriver();
        }
        else if(browserName.equals("ff"))
        {
        	driver=new FirefoxDriver();
        }
        else if(browserName.equals("Safari")) {
        	driver=new SafariDriver();
        }
        else if(browserName.equals("IE"))
        {
        	driver=new InternetExplorerDriver();
        	
        }
        else
        {
        	System.out.println("no browser value is given");
        }
	
        driver.get(prop.getProperty("url"));
        
        driver.findElement(By.className(prop.getProperty("freecrm_logoimage_classname"))).isDisplayed();
        driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys(prop.getProperty("username"));
        driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys(prop.getProperty("password"));
        Thread.sleep(2000);
        driver.switchTo().frame("intercom-borderless-frame");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]")))
				.build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
        driver.findElement(By.name(prop.getProperty("loginBtn_xpath"))).click();
        
        
        
	}

}
