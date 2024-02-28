package pageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SDETregistrationLocators {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(), 'Java SDET Academy')]")
	public WebElement SDETacademy_btn;
	
	@FindBy(xpath = "//input[@type = 'text' and @name = 'fields[first_name]']")
	public WebElement firstname;
	
	@FindBy(xpath =  "//input[@type = 'text' and @name = 'fields[last_name]']")
	public WebElement lastname;
	
	@FindBy(xpath =  "//input[@type = 'email' and @name = 'email_address']")
	public WebElement email_address;
	
	@FindBy(xpath =  "//input[@type = 'text' and @name = 'fields[phone]']")
	public WebElement phone_number;
	
	@FindBy(xpath =  "//button[@class = 'formkit-submit']")
	public WebElement Get_Early_Access_Submit;
	
	@FindBy(xpath = "//h1[contains(text(), 'Oh no, looks like we can’t access this right now')]")
	public WebElement text_confirmation;
	
	@FindBy(xpath = "//button[@class = 'formkit-close']")
	public WebElement close_prompt;
	
	@FindBy(xpath = "//div[@class = 'recaptcha-checkbox-border' and @role = 'presentation']")
	public WebElement captcha_checkbox;
	
	@FindBy(xpath = "//button[@type = 'submit' and contains(text(), 'Subscribe')]")
	public WebElement captcha_subsribe;
	
	
	public SDETregistrationLocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
