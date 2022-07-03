package com.jbk.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTestCases {
	WebDriver driver = null;

	@BeforeTest
	public void BeforeTest() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///C:/Users/Dell/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");

	}

	@Test
	public void loginCheck() {
		String text = driver.findElement(By.xpath("//h4")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String dashbord = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertEquals(dashbord, "Dashboard Courses Offered");
	}
	@Test
	public void BlankMailPassword() {
		SoftAssert assert1 = new SoftAssert();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
		driver.findElement(By.xpath("//button")).click();
		String email =driver.findElement(By.xpath("//div[text()='Please enter email.']")).getText();
		String password = driver.findElement(By.xpath("//div[text()='Please enter password.']")).getText();
		System.out.println(email);
		System.out.println(password);
		assert1.assertEquals(email,"Please enter email.");
	    assert1.assertEquals(password, "Please enter password.");
		
	}
	@Test
	public void testEelements() {
		WebElement image = driver.findElement(By.xpath("//img"));
		boolean value = image.isDisplayed();
		System.out.println(value);
		Assert.assertEquals(value, true);
	}
	@Test
	public void checkContains() {
		String contains = driver.findElement(By.xpath("//b//following::h4[text()=\"JAVA | SELENIUM | PYTHON\"]")).getText();
		System.out.println(contains);
		Assert.assertEquals(contains,"JAVA | SELENIUM | PYTHON");
		
	}

}