package com.Selinium.Sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch the chrome driver
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("pbharat1992");
		driver.findElement(By.name("password")).sendKeys("P@bharat3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		// *[@id="vContactsForm"]/table/tbody/tr[4]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[7]/td[2]/a

		/*
		 * //Method 1 String before_xpath="//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		 * String after_xpath="]/td[2]/a"; for(int i=4;i<=7;i++) { String
		 * name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		 * System.out.println(name); if(name.contains("kumar bharat"))//i=6
		 * //*[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		 * driver.findElement(By.xpath("//*[@id=\\\"vContactsForm\\\"]/table/tbody/tr["+
		 * i+"]/td[2]/a"));
		 * 
		 * }
		 */
		// Meethod 2
		driver.findElement(By.xpath(
				"//a[contains(text(),'kumar bharat')]/parent::td//preceding-sibling::td//input[@name='contact_id']"))
				.click();
		driver.findElement(By.xpath(
				"//a[contains(text(),'pawan kalyan')]/parent::td//preceding-sibling::td//input[@name='contact_id']"))
				.click();

	}

}
