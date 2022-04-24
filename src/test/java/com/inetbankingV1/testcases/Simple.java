package com.inetbankingV1.testcases;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Simple {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--disable-infobars");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/index.php");
		driver.findElement(By.name("uid")).sendKeys("mngr397760");
		driver.findElement(By.name("password")).sendKeys("Eqyvyta");
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.linkText("New Customer")).click();
	}

}
