package com.shoping.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.shoping.base.BaseTest;

public class ReadConfig extends BaseTest {
	public static Properties prop = null;

	public ReadConfig() {
		try {

			prop = new Properties();
			prop.load(new FileInputStream(
					new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\shoping\\config\\config.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
 
 
	public String getChromePath() {
		return prop.getProperty("chormePath");
	}

	public String getFrefoxPath() {
		return prop.getProperty("firefoxPath");
	}

	public String getEdgePath() {
		return prop.getProperty("edgePath");
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getTimeout() {

		return prop.getProperty("timeout");

	}

	public String getWebdriverWait() {
		return prop.getProperty("WebdriverWait");

	}

	public CharSequence getserch() {

		return prop.getProperty("serch");
	}

	public String getCartTextInitial() {
		return prop.getProperty("cartTextInitial");
	}

	public CharSequence getresulttext() {

		return prop.getProperty("resulttext");
	}

	public String getUrls() {
		return prop.getProperty("baseUrl");
	}

	public CharSequence getFraindName() {

		return prop.getProperty("fraindNameBox");
	}

	public CharSequence getFraindMail() {

		return prop.getProperty("fraindMailBox");
	}

	public CharSequence getcurancy() {

		return prop.getProperty("curancy");
	}

	public String getMessageAfterRMProduct() {

		return prop.getProperty("massageAfterRMProduct");
	}

}
