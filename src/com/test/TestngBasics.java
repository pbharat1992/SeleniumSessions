package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasics {
	// output
	// @BeforeSuite---setup system property for chrome-1
	// @BeforeTest---login method-2
	// @BeforeClass---launch chrome browser-3

	// @BeforeMethod---enter url-4
	// @Test---google logo text
	// @AfterMethod ---logout method

	// @BeforeMethod---enter url
	// @Test---google title test
	// @AfterMethod ---logout method

	// @BeforeMethod---enter url
	// @Test---search url
	// @AfterMethod ---logout method

	// @AfterClass---closing the browser
	// @AfterTest---delete all cookies

	// pre-conditional annotations--starting with @Before
	@BeforeSuite // 1
	public void setUp() {
		System.out.println("@BeforeSuite---setup system property for chrome");
	}

	@BeforeTest // 2
	public void Login() {
		System.out.println("@BeforeTest---login method");
	}

	@BeforeClass // 3
	public void launchBrowser() {
		System.out.println("@BeforeClass---launch chrome browser");
	}

	@BeforeMethod // 4 //we can execute n no of times
	public void enterURL() {
		System.out.println("@BeforeMethod---enter url");
	}

	// test cases-starting with @Test
	@Test // 5
	public void googleTitleTest() {
		System.out.println("@Test---google title test");
	}

	@Test // 6
	public void searchUrl() {
		System.out.println("@Test---search url");
	}

	@Test // 7
	public void googleLogoText() {
		System.out.println("@Test---google logo text");
	}

	// Post conditions---starting with @After
	@AfterMethod // we can execute n no of times
	public void logOut() {
		System.out.println("@AfterMethod ---logout method");
	}

	@AfterTest
	public void deleteAllCookies() {
		System.out.println("@AfterTest---delete all cookies");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("@AfterClass---closing the browser");
	}

	@AfterSuite
	public void generateTestReport() {
		System.out.println("@AfterSuite---generateTestReport");
	}

}
