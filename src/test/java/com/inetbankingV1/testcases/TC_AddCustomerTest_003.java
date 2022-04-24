package com.inetbankingV1.testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.inetbankingV1.pageobjects.AddCustomerPage;
import com.inetbankingV1.pageobjects.Login;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test()
	public void addcustomer() throws InterruptedException {
		Login login = new Login(driver);
		login.setusername(usrname);
		login.setpassword(pwd);
		login.click();
		Thread.sleep(1000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clicknewcustomer();
		log.info("Clicking on New customer link");
		Thread.sleep(5000);
		switchframe();
		/*
		 * Alert alert = driver.switchTo().alert(); alert.dismiss();
		 */
		Thread.sleep(1000);
		addcust.custName("Piyush");
		log.info("Entering customer Name");
		addcust.custGender("Male");
		log.info("Selecting Gender");
		addcust.custdob(19, 04, 2022);
		log.info("Entering Date of Birth customer");
		addcust.CustAddress("India");
		log.info("Entering Customer Address");
		addcust.Custcity("HYD");
		log.info("Entering Customer City");
		addcust.CustState("AP");
		log.info("Entering State Name");
		addcust.CustPinno(5000074);
		log.info("Entering Pin no of Customer");
		addcust.CustMobNo("9304045392");
		log.info("Entering Customer Mobile Number");
		String email = randomString() + "@gmail.com";
		addcust.CustEmail(email);
		log.info("Entering Customer Email ID");
		addcust.CustPassword("Piyush123");
		log.info("Entering Customer Password");
		addcust.clickonsubmitbtn();
	}
}
