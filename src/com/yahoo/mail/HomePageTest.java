package com.yahoo.mail;

import java.util.ArrayList;
import java.util.Iterator;

//import java.util.ArrayList;
//import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.test.utility.TestUtil;

public class HomePageTest {

	WebDriver fxDriver;
	Logger log = Logger.getLogger(HomePageTest.class);

	@BeforeMethod
	public void loaunchBrowserTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\eclipse-workspace\\thaismile\\Driver\\geckodriver.exe");

		fxDriver = new FirefoxDriver();
		fxDriver.manage().deleteAllCookies();
		// fxDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// fxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// fxDriver.get("https:www.thaismileair.com/en");
		// log.info("Home page launched.");

	}

	@Test
	public void loaunchHomePageTest() {
		fxDriver.get("https:www.thaismileair.com/en");
		log.info("Home page launched.");

		String title = fxDriver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,
				"Thai Smile Airways | Fly Smart with THAI Smile | Thailand Domestic and Asia Regional Flight");
		log.info("Page Title verified.");
	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void yahooMailRegistrationTest(String firstname, String lastname, String emailaddress, String password,
			String cell, String month, String day, String year, String gender) throws Exception {

		fxDriver.get(
				"https://login.yahoo.com/account/create?lang=&done=https%3A%2F%2Fmail.yahoo.com%2F&src=ym&specId=yidReg");
		log.info("Yahoo Registration Page Launched. ");

		// Passing values from Excel file

		fxDriver.findElement(By.xpath("//input[contains(@class, 'ureg-fname ')]")).clear();
		fxDriver.findElement(By.xpath("//input[contains(@class, 'ureg-fname ')]")).sendKeys(firstname);

		fxDriver.findElement(By.xpath("//input[contains(@class, 'ureg-lname ')]")).clear();
		fxDriver.findElement(By.xpath("//input[contains(@class, 'ureg-lname ')]")).sendKeys(lastname);

		fxDriver.findElement(By.xpath("//input[@name= 'yid']")).clear();
		fxDriver.findElement(By.xpath("//input[@name= 'yid']")).sendKeys(emailaddress);

		fxDriver.findElement(By.xpath("//input[@name= 'password']")).clear();
		fxDriver.findElement(By.xpath("//input[@name= 'password']")).sendKeys(password);

		fxDriver.findElement(By.xpath("//input[@name='phone']")).clear();
		fxDriver.findElement(By.xpath("//input[@name='phone']")).sendKeys(cell);
		Thread.sleep(1000);

		Select select = new Select(fxDriver.findElement(By.xpath("//select [@id]")));
		select.selectByVisibleText(month);

		fxDriver.findElement(By.xpath("//input[@name='dd']")).clear();
		fxDriver.findElement(By.xpath("//input[@name='dd']")).sendKeys(day);

		fxDriver.findElement(By.xpath("//input[@name='yyyy']")).clear();
		fxDriver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys(year);

		fxDriver.findElement(By.xpath("//input [@name ='freeformGender']")).clear();
		fxDriver.findElement(By.xpath("//input [@name ='freeformGender']")).sendKeys(gender);

	}

	@AfterMethod
	public void tearDown() {

		fxDriver.quit();

	}

}