package com.inetbankingV1.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.utilities.DataUtils;
import com.inetbankingV1.pageobjects.Login;

public class TC01_LoginTest extends BaseClass {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "dp")
	public void LoginTest(String username, String password) throws InterruptedException {
		Login loginpage = new Login(driver);
		Thread.sleep(2000);
		loginpage.setusername(username);
		log.info("Entered username");
		loginpage.setpassword(password);
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
