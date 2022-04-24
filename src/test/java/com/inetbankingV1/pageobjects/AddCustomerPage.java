package com.inetbankingV1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	public WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(how = How.LINK_TEXT, using = "New Customer")
	public WebElement linAddnewcustomer;
	@FindBy(how = How.NAME, using = "name")
	public WebElement txtCustomername;
	@FindBy(how = How.NAME, using = "rad1")
	public WebElement rdGender;
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	public WebElement txtdob;
	@FindBy(how = How.NAME, using = "addr")
	public WebElement txtaddress;

	@FindBy(how = How.NAME, using = "city")
	public WebElement txtcity;

	@FindBy(how = How.NAME, using = "state")
	public WebElement txtstate;
	@FindBy(how = How.NAME, using = "pinno")
	public WebElement txtpinno;
	@FindBy(how = How.NAME, using = "telephoneno")
	public WebElement txtmobno;
	@FindBy(how = How.NAME, using = "emailid")
	public WebElement txtemail;
	@FindBy(how = How.NAME, using = "password")
	public WebElement txtpassword;
	@FindBy(how = How.NAME, using = "sub")
	public WebElement btnSubmit;
	
	

	public void dorefresh() {
		driver.navigate().refresh();
	}
	
	public void clicknewcustomer() {
		linAddnewcustomer.click();
	}

	public void custName(String customerName) {
		txtCustomername.sendKeys(customerName);
	}

	public void custGender(String customergender) {

		rdGender.click();
	}

	public void custdob(int dd, int mm, int yyyy) {
		txtdob.sendKeys(String.valueOf(dd));
		txtdob.sendKeys(String.valueOf(mm));
		txtdob.sendKeys(String.valueOf(yyyy));
	}

	public void CustAddress(String customerAddress) {
		txtaddress.sendKeys(customerAddress);
	}

	public void Custcity(String customercity) {
		txtcity.sendKeys(customercity);
	}

	public void CustState(String customerstate) {
		txtstate.sendKeys(customerstate);
	}

	public void CustPinno(int customerpinno) {
		txtpinno.sendKeys(String.valueOf(customerpinno));
	}

	public void CustMobNo(String customerMobNo) {
		txtmobno.sendKeys(customerMobNo);
	}

	public void CustEmail(String customerEmaiId) {
		txtemail.sendKeys(customerEmaiId);
	}

	public void CustPassword(String custpasswrd) {
		txtpassword.sendKeys(custpasswrd);
	}

	public void clickonsubmitbtn() {
		btnSubmit.click();

	}

	
}
