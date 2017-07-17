/**
 * 
 */
package com.test.automation.login;

import org.openqa.selenium.WebDriver;

import com.test.automation.common.ConfUtil;
import com.test.automation.common.Util;

/**
 * @author Prahlad created on 14-Jul-2017
 *
 */
public class Login {
	
	
	public void enterLoginURL(WebDriver driver, String appUrl) {
		System.out.println(appUrl);
		driver.get(appUrl);
	}
	
	public void loginToWeb(WebDriver driver, String userName, String password) {
		try {
			LoginConf loginConf = ConfUtil.getLoginConf();
			Util.sendKeys(driver, loginConf.getLogin_name(), userName);
			Util.sendKeys(driver, loginConf.getLogin_password(), password);
			Util.click(driver, loginConf.getLogin_btn());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
