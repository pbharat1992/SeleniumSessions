package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader1;

public class ParameterizeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// webdriver code
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// launch browser

		driver.get("https://reg.ebay.in/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.in%2F"); // enter url

		// Data driven approach(Parameterization)---used to create data driven
		// framework: driving the test data from excel files
		// get the data from the excel file
		Xls_Reader1 reader = new Xls_Reader1(
				"D:\\eclipse oxyzen\\eclipse\\CHARI\\SeliniumSessions\\src\\com\\testdata\\Ebay.xslx.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		reader.addColumn("RegTestData", "Status");
		reader.addSheet("kumar");

		// parameterization by using for loop
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			System.out.println("############");

			String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstName);

			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastName);

			String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
			System.out.println(emailaddress);

			String Password = reader.getCellData("RegTestData", "Password", rowNum);
			System.out.println(Password);

			driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstName);

			driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastName);

			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailaddress);

			driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(Password);

			reader.setCellData("RegTestData", "Status", rowNum, "pass");// write the data into cell in excel sheet
		}

	}

}
