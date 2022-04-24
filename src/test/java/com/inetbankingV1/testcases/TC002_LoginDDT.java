package com.inetbankingV1.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.utilities.DataUtils;
import com.inetbankingV1.pageobjects.Login;

public class TC002_LoginDDT extends BaseClass {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "dp")
	public void LoginCredential(String usrname, String pasword) {
		Login logins = new Login(driver);
		logins.setusername(usrname);
		log.info("Entered username");
		logins.setpassword(pasword);
		log.info("Password entered");
		logins.click();
		if (isalertpresent() == true) {
			log.warn("Test Case failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			log.info("Test case Passed");
			logins.Logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isalertpresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

}
