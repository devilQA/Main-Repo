package Baseclass;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ReadPropData;

public class BaseTest {
public static	WebDriver driver= null;
public static	Properties prop= null;
	public static void initializ() {
		prop=ReadPropData.getpropdata("C:\\Users\\admin\\MyWorkspace\\user-story-verify\\src\\main\\java\\TestData\\config.properties");
		
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
			driver= new ChromeDriver();
		}else {
			throw new RuntimeException();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeout")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("baseurl"));
		
	}
public static void TearDown() {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}
}
