package com.inetbanking.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbankingV1.testcases.BaseClass;

public class Reporting extends TestListenerAdapter {
	public ExtentSparkReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	public String screenshotname;

	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getTestClass().getName()+"@Test Case :"+ tr.getMethod().getMethodName());

		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {
		BaseClass.capturescreenshot();

		test.fail(tr.getThrowable());
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		screenshotname = BaseClass.srcfilename;
		test.fail("Screenshot is below", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshot/" + screenshotname).build());
	}

	public void onTestSkipped(ITestResult tr) {

		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {

	}

	public void onStart(ITestContext testContext) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname = "Test-Report" + timestamp + ".html";
		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repname);
		htmlreporter.config().setDocumentTitle("Automation Test Result");
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setReportName("Automation Result");
		try {
			htmlreporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Automation Tester", "Piyush");
		extent.setSystemInfo("Build No", "234");
		extent.setSystemInfo("Organization", "Tata");

	}

	public void onFinish(ITestContext testContext) {
		if (extent != null)
			extent.flush();
	}

}