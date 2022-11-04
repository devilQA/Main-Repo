package com.shoping.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shoping.utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	public static ReadConfig config = new ReadConfig();
	public static WebDriverWait wait = null;
	public static Actions action = null;
	public static JavascriptExecutor js;
	public static TakesScreenshot tcs;
	public static void init() {

		String browser = config.getBrowser();
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		 
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
		 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver();
		}

		// drivertimeout
		driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getTimeout()), TimeUnit.SECONDS);

		// base url
		driver.get(config.getUrls());
		// webdriverwait
		wait = new WebDriverWait(driver, Long.parseLong(config.getWebdriverWait()));

		// maximize screen
		driver.manage().window().maximize();
		action = new Actions(driver);

		// javasriptexecutor object
		js=(JavascriptExecutor )driver;
		tcs=(TakesScreenshot)driver;
	}

	public static void tearDown() {
		driver.quit();
	}

}
