package com.test.automation.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {
	public static void sendKeys(WebDriver driver, String objectLocater, String value) {
		System.out.println("Clearing element " + objectLocater + " sending value " + value);
		if (value != null) {
			findElement(driver, objectLocater).clear();
			findElement(driver, objectLocater).sendKeys(value);
		}
	}

	public static WebElement findElement(final WebDriver driver, String objectLocater) {
		String[] splits = null;
		String objecttype = null;
		String objectvalue = null;

		splits = objectLocater.split("~");
		objecttype = splits[0];
		objectvalue = splits[1];

		if (objecttype.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(objectvalue));
		} else if (objecttype.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(objectvalue));
		} else if (objecttype.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(objectvalue));
		}
		return null;
	}

	public static void click(WebDriver driver, String objectLocater) {
		try {
			System.out.println("Clicking on lement : " + objectLocater);
			Thread.sleep(2000);
			findElement(driver, objectLocater).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
