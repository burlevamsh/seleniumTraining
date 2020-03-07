package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")
	WebElement myAccount;

	@FindBy(xpath = "//a[contains(text(),'My Wishlist')]")
	WebElement myWishlist;

	@FindBy(xpath = "//a[contains(text(),'Checkout')]")
	WebElement checkOut;

	@FindBy(xpath = "//a[@class='noo-search']")
	WebElement search;

	@FindBy(xpath = "//span[@class='cart-name-and-total']")
	WebElement cartBag;

	@FindBy(xpath = "//a[@class='custom_link']")
	WebElement viewBlog;

	public void clickOnMyAccount() {
		myAccount.click();
	}

	public void clickOnMyWishlist() {
		myWishlist.click();
	}

	public void checkOut() {
		checkOut.click();
	}

	public void search() {
		search.click(); // input[@name='s']
	}
	
	public void cartBag() {
		cartBag.click();
	}
	
	public void viewBlog() {
		viewBlog.sendKeys(Keys.CONTROL,Keys.ENTER);
	}
  public 	HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
