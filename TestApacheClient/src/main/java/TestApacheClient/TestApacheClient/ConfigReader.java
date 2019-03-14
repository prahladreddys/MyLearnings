package TestApacheClient.TestApacheClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	
	private static ConfigReader configReader = new ConfigReader();
	private static Properties properties = null;
	
	
	private ConfigReader(){		
	}
	
	public static ConfigReader getInstance(){
		return configReader;
	}
	
	public Properties getConfig() {
		if (null == properties) {
			properties = new Properties();
			try {
				properties.load(new FileInputStream(new File("conf/config.properties")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
}
