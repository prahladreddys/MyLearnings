/**
 * 
 */
package com.test.automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Prahlad created on 04-Jul-2017
 *
 */
public class SimpleTest {
	@Test
	public void testMeth(){
		Simple simple = new Simple();
		String result = simple.meth();
		
		Assert.assertNotNull(result);
		Assert.assertEquals(result, "hello");
	}
	@Test
	public void loadWebsite(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println("Page Title: "+ driver.getTitle());
		assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
