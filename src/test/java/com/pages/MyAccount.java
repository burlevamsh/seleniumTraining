package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends HomePage {

	@FindBy(xpath = "//input[@id='reg_username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='reg_email']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='reg_password']")
	WebElement password;

	@FindBy(xpath = "//button[@name='register']")
	WebElement registerBtn;

	public void userName(String username) {
		userName.sendKeys(username);
	}

	public void emailAddress(String emailaddress) {
		emailAddress.sendKeys(emailaddress);
	}
	
	public void password(String passwordEntered) {
		password.sendKeys(passwordEntered);
	}
	
	public void register() {
		registerBtn.click();
	}
	
	public MyAccount(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

}
