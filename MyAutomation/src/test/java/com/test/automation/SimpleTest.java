/**
 * 
 */
package com.test.automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.common.SetUp;
import com.test.automation.login.Login;

/**
 * @author Prahlad created on 04-Jul-2017
 *
 */
public class SimpleTest {
	private WebDriver driver;
	private ExtentReports report;
	private ExtentTest logger;

	@BeforeSuite
	public void beforeTest() {
		driver = SetUp.getDriver();
		report = SetUp.getExtentReports();
		logger = SetUp.getExtentTest();
	}

	@Test
	public void loginTest() throws InterruptedException {

		Login login = new Login();
		login.enterLoginURL(driver, System.getProperty("appUrl"));
		Thread.sleep(5000);
		String userName = System.getProperty("usn");
		String psw = System.getProperty("psw");
		login.loginToWeb(driver, userName, psw);
		logger.log(LogStatus.INFO, "Page Title: " + driver.getTitle());
		assertEquals("Login Page", driver.getTitle());
		Thread.sleep(5000);
		logger.log(LogStatus.INFO, "Success");
		report.endTest(logger);
	}

	@AfterSuite
	public void end() {
		report.flush();
		driver.quit();
		report.close();
	}

	@Test
	public void testMeth() {
		Simple simple = new Simple();
		String result = simple.meth();

		Assert.assertNotNull(result);
		Assert.assertEquals(result, "hello");
	}

	// @Test
	public void loadWebsite() throws InterruptedException {

		driver.get("http://www.news.google.com");
		logger.log(LogStatus.INFO, "Page Title: " + driver.getTitle());
		assertEquals("Google News", driver.getTitle());
		Thread.sleep(5000);
		logger.log(LogStatus.INFO, "Success");
		report.endTest(logger);
	}
}
