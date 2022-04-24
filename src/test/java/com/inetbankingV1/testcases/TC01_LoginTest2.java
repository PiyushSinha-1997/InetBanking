package com.inetbankingV1.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.utilities.ConfigReader;
import com.inetbankingV1.pageobjects.Login;

public class TC01_LoginTest2 extends BaseClass {

	@Test
	public void LoginTest() {
		Login loginpage = new Login(driver);
		loginpage.setusername(ConfigReader.getusername());
		log.info("Entered username");
		loginpage.setpassword(ConfigReader.getpassword());
		log.info("Entered password");
		loginpage.click();
		log.info("Clicking on Login button");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			System.out.println(driver.getTitle());
			log.info("Test case passed");
		}

		else {
			Assert.assertTrue(false);
			log.info("Test Case failed");
		}
	}
}
