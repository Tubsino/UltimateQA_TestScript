package stepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	private static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static MutableCapabilities capabilities;
	public static HashMap<String, Object> browserstackOptions;
	public static String url;
	
	@BeforeAll
	public static void setup() throws MalformedURLException {
		if(driver==null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		capabilities = new MutableCapabilities();
//		browserstackOptions = new HashMap<String, Object>();
		
		if(config.getProperty("Browser").equals("Chrome")) {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver.manage().window().maximize();
//			capabilities.setCapability("browserName", config.getProperty("Browser"));
//			capabilities.setCapability("browserVersion", config.getProperty("browserVersion"));
//			browserstackOptions.putIfAbsent("source", "cucumber-java:sample-master:v1.2");
//			browserstackOptions.put("os", config.getProperty("os"));
//			browserstackOptions.put("osVersion", config.getProperty("osVersion"));
//			browserstackOptions.put("buildName", config.getProperty("buildName"));
//			browserstackOptions.put("sessionName", config.getProperty("sessionName"));
//			browserstackOptions.put("local", config.getProperty("local"));
//			browserstackOptions.put("seleniumVersion", config.getProperty("seleniumVersion"));
//			capabilities.setCapability("bstack:options", browserstackOptions);
//			url = "https://" + config.getProperty("userName") + ":" + config.getProperty("accessKey")  + config.getProperty("hubUrl");
//			driver = new RemoteWebDriver(new java.net.URL(url), capabilities);
			driver.get(config.getProperty("AppURL"));
			
		}else if(config.getProperty("Browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
//			driver = new RemoteWebDriver(new java.net.URL(url), capabilities);
			driver.get(config.getProperty("AppURL"));
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	@AfterAll
	public static void tearDown() {
		if(driver != null) {
			driver.close();
		}
	}

}
