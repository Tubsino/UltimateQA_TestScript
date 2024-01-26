package stepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	private static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	
	@BeforeAll
	public static void setup() {
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
		
		if(config.getProperty("Browser").equals("Chrome")) {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver.manage().window().maximize();
			driver.get(config.getProperty("AppURL"));
			
		}else if(config.getProperty("Browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
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
