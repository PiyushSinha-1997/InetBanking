package com.inetbanking.utilities;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends TestListenerAdapter {

	public ExtentSparkReporter htmlReporter; // Add configuration and create a html file
	public ExtentReports extent; // add some system config, create test cases , attach report
	public ExtentTest test; // create log status in report like pass/fail/skip

	@BeforeTest
	public void setReport() {
		htmlReporter = new ExtentSparkReporter("./reports/Extent.html");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setReportName("Automation Test Result");
		htmlReporter.config().setDocumentTitle("W2A Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Automation Tester", "Piyush");
		extent.setSystemInfo("Build No", "234");
		extent.setSystemInfo("Organization", "Tata");
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		
		
		
		
	}

}
