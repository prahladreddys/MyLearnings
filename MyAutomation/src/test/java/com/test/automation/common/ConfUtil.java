/**
 * 
 */
package com.test.automation.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import com.test.automation.login.LoginConf;

/**
 * @author Prahlad created on 14-Jul-2017
 *
 */
public class ConfUtil {
	public static LoginConf getLoginConf(){
		Properties prop = new Properties();
		LoginConf loginConf = new LoginConf();
		try(InputStream input= getStream("login.conf")) {

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("login_name"));
			System.out.println(prop.getProperty("login_password"));
			System.out.println(prop.getProperty("login_btn"));
			loginConf.setLogin_name(prop.getProperty("login_name"));
			loginConf.setLogin_password(prop.getProperty("login_password"));
			loginConf.setLogin_btn(prop.getProperty("login_btn"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		return loginConf;
	}
	public static void main(String[] args) {
		getLoginConf();
	}
	private static InputStream getStream(final String resource) throws IOException {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
    }
}
