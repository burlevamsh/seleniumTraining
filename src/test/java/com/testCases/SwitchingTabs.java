package com.testCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.MyAccount;

public class SwitchingTabs {

	WebDriver driver;
	MyAccount MyAccount;

	@BeforeSuite
	public void invokebrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
	}

	@BeforeTest
	public void intilizeBrowseer() {

		driver = new ChromeDriver();
		String url = "http://shop.demoqa.com/";
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'woocommerce-store-notice__dismiss-link')]")).click();
		MyAccount = new MyAccount(driver);
	}

	@Test
	public void switchTest() {
		
		 String oldTab = driver.getWindowHandle();
		MyAccount.viewBlog();
		
		 ArrayList<String> ar = new ArrayList<String>(driver.getWindowHandles());
		//    newTab.remove(oldTab);
		    Iterator<String> itr = ar.iterator();
		    String parentName =itr.next();
		    String childName =itr.next();
		    
		 // change focus to new tab
		    driver.switchTo().window(childName);
		    
		 // change focus back to old tab
		    driver.switchTo().window(parentName);
		
		

	}
	
	@AfterTest
	public void atLast() {
		driver.close();
	}

}
