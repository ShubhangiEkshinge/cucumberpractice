package com.testingshastra.util;

import static com.testingshastra.util.PropertiesFile.getObject;

public class Locator {
//static import is type in java,we can use this for import the static member of any class 
	// public static final String SINGUP_FULLNAME =
	// PropertiesFile.getObject("signup.fullname");
	//static final keywords always return in CapitalCase
	public static final String SINGUP_FULLNAME = getObject("signup.fullname");
	public static final String SINGUP_COMPANYNAME = getObject("signup.companyname");
	public static final String SIGNUP_EMAIL = getObject("signup.email");
	public static final String SIGNUP_CONTACT = getObject("signup.contact");
	public static final String SIGNUP_PASSWORD = getObject("signup.password");
	public static final String SIGNUP_IANNOTROBOT = getObject("signup.iannotrobot");
	public static final String SIGNUP_SIGNUPBTN = getObject("signup.signupbtn");
}
