package com.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.pages.HomePage;
import com.pages.MyAccount;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.XLSLFile;

public class TestRegistration {
	
	WebDriver driver;
	HomePage HomePage;
	MyAccount MyAccount;
	
	
	@BeforeSuite
	public void invokebrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
	}
	
	@BeforeTest
	public void intilizeBrowseer() {
		
		driver=new ChromeDriver();
		String url="http://shop.demoqa.com/";
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'woocommerce-store-notice__dismiss-link')]")).click();
		MyAccount=new MyAccount(driver);
		MyAccount.clickOnMyAccount();
	}
	
	@DataProvider(name="LoginDetails")
	public Object[][] dataprovide(){
		
		return XLSLFile.getXLSXFile("D:\\ctsjava\\howerver\\src\\test\\resources\\TestData\\regiesterDetails.xlsx");
	}
	
	@Test(dataProvider="LoginDetails")
	public void registrationTest(String username,String e_mail,String passWord) {
		
		
		MyAccount.userName(username);
		MyAccount.emailAddress(e_mail);
		MyAccount.password(passWord);
		MyAccount.register();
		
	}
	
	@AfterTest
	public void atLast() {
		driver.close();
	}

}
