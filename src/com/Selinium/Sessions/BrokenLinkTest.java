package com.Selinium.Sessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
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
		driver.switchTo().frame("mainpanel");
		// links--//a
		// images--//img
		// 1.get the list of all the links and images
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("size of full links and images are==" + linklist.size());

		ArrayList<WebElement> activelinks = new ArrayList<WebElement>();

		// 2.interate linklist:exclude all the links and images-doesn't have any href
		// attribute
		for (int i = 0; i < linklist.size(); i++) {
			System.out.println(linklist.get(i).getAttribute("href"));
			if (linklist.get(i).getAttribute("href") != null
					&& (!linklist.get(i).getAttribute("href").contains("javascript"))) {
				activelinks.add(linklist.get(i));
			}

		}
		// get the size of active links list
		System.out.println("size of active links and images are==" + activelinks.size());

		// 3.check the href url,with httpconnection api:
		// 200--ok
		// 404--not found
		// 500--internal error
		// 400---bad request
		for (int j = 0; j < activelinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href"))
					.openConnection();

			connection.connect();
			String response = connection.getResponseMessage();// ok
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href") + "----->" + response);

		}

	}

}
