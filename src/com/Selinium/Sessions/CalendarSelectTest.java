
//Method 1: Asking at the time of interiew for checking the coding skills

package com.Selinium.Sessions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch the chrome driver
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("pbharat1992");
		driver.findElement(By.name("password")).sendKeys("P@bharat3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame("mainpanel");
		String date1 = "28-April-2018";
		String dateArr[] = date1.split("-");// [28,April,2018]
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText(year);
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
		String before_xpath = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath = "]/td[";
		final int totalWeekDays = 7;

		boolean flag = false;
		String dayVal = null;
		for (int rowNum = 2; rowNum <= 7; rowNum++)

		{
			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {

				try {
					dayVal = driver.findElement(By.xpath(before_xpath + rowNum + after_xpath + colNum + "]")).getText();
				} catch (NoSuchElementException e) {
					System.out.println("please enter a correct datevalue");
					flag = false;
					break;
				}
				System.out.println(dayVal);
				if (dayVal.equals(day))

					driver.findElement(By.xpath(before_xpath + rowNum + after_xpath + colNum + "]")).click();
				flag = true;
				break;

			}
			if (flag) {
				break;

			}
		}
	}
}
