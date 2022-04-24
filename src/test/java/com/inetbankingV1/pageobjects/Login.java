package com.inetbankingV1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utilities.ConfigReader;

public class Login {

	public WebDriver driver;// webdriver reference

	// Constructor

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Webelements on Login page
	@FindBy(name = "uid")
	public WebElement userid;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(name = "btnLogin")
	public WebElement loginbtn;
	@FindBy(linkText = "Log out")
	public WebElement logoutlink;

	// Creating action method
	public void setusername(String usrname) {
		userid.sendKeys(usrname);
	}

	public void setpassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void click() {
		loginbtn.click();
	}

	public void Logout() {
		logoutlink.click();
	}

	public AddCustomerPage doLogin(String usrname, String pwd) {
		userid.sendKeys(usrname);
		password.sendKeys(pwd);
		loginbtn.click();
		return new AddCustomerPage(driver);
	}

	
}
