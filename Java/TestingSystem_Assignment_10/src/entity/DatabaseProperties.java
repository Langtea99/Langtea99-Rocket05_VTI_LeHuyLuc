package entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {
	public static final String URL = "C:\\Users\\Shadow\\Desktop\\Rocket05_VTI_LeHuyLuc\\Java\\TestingSystem_Assignment_10\\src";

	private Properties properties;

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
