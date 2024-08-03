package com.java.framework;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;

public class Log {
	public static Logger log = Logger.getLogger(Log.class.getName());
	
	public static void reportResult(boolean result, String passMsg, String failMsg ) {
		boolean flag=result;
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\log4j.properties");
		try {
			if(flag==true)
				log.info(passMsg);
			else if(flag==false)
				log.error(failMsg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Assert.assertTrue(flag);
	}
}
