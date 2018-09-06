package com.praticeprograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FreeCRMDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");	
	  WebDriver	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("pbharat1992");
		driver.findElement(By.name("password")).sendKeys("P@bharat3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		
		driver.switchTo().frame("mainpanel");
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
        Select select=new Select(driver.findElement(By.name("title")));
       List <WebElement> elementCount=select.getOptions(); 
      int elementSize=elementCount.size();
      for(int i =0; i<elementSize ; i++){
  		String sValue = elementCount.get(i).getText();
  		System.out.println(sValue);
  		}
      
      
	}

}
