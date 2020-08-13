package entity;

import java.util.Properties;

public class MessageProperties {
	private Properties properties;
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
