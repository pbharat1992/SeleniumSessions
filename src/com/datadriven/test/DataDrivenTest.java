package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader1;

public class DataDrivenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// get the data from the excel file
		Xls_Reader1 reader = new Xls_Reader1(
				"D:\\eclipse oxyzen\\eclipse\\CHARI\\SeliniumSessions\\src\\com\\testdata\\Ebay.xslx.xlsx");

		String firstName = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstName);

		String lastName = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastName);

		String emailaddress = reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(emailaddress);

		String Password = reader.getCellData("RegTestData", "Password", 2);
		System.out.println(Password);

		// webdriver code
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// launch browser

		driver.get("https://reg.ebay.in/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.in%2F"); // enter url

		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("panuganti");

		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("bharatkumarchari");

		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kumarjj9@gmail.com");

		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys("P@bharat3");

	}

}
