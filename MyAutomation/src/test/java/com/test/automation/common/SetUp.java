package com.test.automation.common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SetUp {
	private static WebDriver driver;
	private static ExtentReports report;
	private static ExtentTest test;
	
	private SetUp() {
		super();
	}


	public static WebDriver getDriver(){
		if(driver == null ){
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");		
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static ExtentReports getExtentReports(){
		if(report == null){
			report = new ExtentReports("reports/index.html",true);
			report.loadConfig(new File("extent.xml"));
		}
		return report;
	}
	
	public static ExtentTest getExtentTest(){
		if(test == null){
			test = getExtentReports().startTest("MyTests");
		}
		return test;
	}
}
