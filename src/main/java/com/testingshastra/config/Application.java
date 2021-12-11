package com.testingshastra.config;

import com.testingshastra.util.PropertiesFile;
//Use of this class is-Reading the application.properties file

public class Application {
	private static final String FILEPATH = "/src/main/resources/application.properties";

	public String getBrowser() {
		return PropertiesFile.getProperty(FILEPATH, "daisy.browser");
	}

	public String getAppUrl() {
		return PropertiesFile.getProperty(FILEPATH, "daisy.dev.app.url");
	}

	public String getDbUrl() {
		return null;

	}

	public String getUserName() {
		return null;

	}

	public String getPassword() {
		return null;

	}
}
