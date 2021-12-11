package com.testingshastra.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static String getProperty(String fileName, String key) {
		String dir = System.getProperty("user.dir");
		String value = "";
		try {
			FileInputStream fis = new FileInputStream(dir +fileName);
			Properties prop = new Properties();// It's a class,hashTable is Backed-Data structure of properties(c)
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * This method returns the value of locator mentioned in objectRepository
	 * 
	 * @param key
	 */

	public static String getObject(String key) {
		return getProperty("/src/test/resources/ObjectRepository.properties", key);
		//to avoid the duplicacy
	}
//		String dir = System.getProperty("user.dir");
//		String value = "";
//		try {
//			FileInputStream fis = new FileInputStream(dir + "/src/test/resources/ObjectRepository.properties:");
//			Properties prop = new Properties();// It's a class,hashTable is Backed-Data structure of properties(c)
//			prop.load(fis);
//			value = prop.getProperty(key);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return value;
//	}
}
